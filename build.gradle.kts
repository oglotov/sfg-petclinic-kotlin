import pl.allegro.tech.build.axion.release.domain.preRelease

plugins {
    // Gradle Release Plugin https://axion-release-plugin.readthedocs.io/en/latest/
    id("pl.allegro.tech.build.axion-release") version "1.14.2"
}

repositories {
    mavenCentral()
}

scmVersion {
    useHighestVersion.set(true)
    tag {
        prefix.set("v")
        versionSeparator.set(".")
        initialVersion({config, position -> "0.0.1"})
    }
    repository {
        type.set("git")
        val credentials = file("github-axion-release-credentials.txt").readLines()
        //println(credentials.toString())
        customUsername.set(credentials[0])
//        customUsername.set(file("github-axion-release-token.txt").readText())
//        customPassword.set("")
//        customKeyFile.set(file(System.getProperty("user.home") + "${File.separator}.ssh${File.separator}id_rsa"))
        customPassword.set(credentials[1])
    }
    checks {
        aheadOfRemote.set(false)
        snapshotDependencies.set(true)
    }
    hooks {
        preRelease {
            push()
            commit { releaseVersion, position -> "New commit message for version $releaseVersion" }
            custom { context -> println("$context")}
            fileUpdate {
                file("README.md") // repeat for additional files
                pattern = {previousVersion,context -> "version: $previousVersion"}
                replacement = {currentVersion,context -> "version: $currentVersion"}
            }
        }
    }
    versionCreator("versionWithBranch")
}

project.version = scmVersion.version

//allprojects {
//    project.version = scmVersion.version
//}

/*
task("loadGitHubToken") {
    val credentials = file("github-axion-release-credentials.txt").readLines()
    scmVersion.repository.customUsername.set(credentials[0])
    scmVersion.repository.customPassword.set(credentials[1])
}*/
