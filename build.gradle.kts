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
//        customKeyFile.set(project.file("keys/id_ed25519"))
//        customKeyPassword.set("")
//        val credentials = file("github-axion-release-credentials.txt").readLines()
//        customUsername.set(credentials[0])
//        customPassword.set(credentials[1])
//        println("${customUsername.get()} ${customPassword.get()}")
        //customUsername.set(credentials[0])
//        customUsername.set(file("github-axion-release-token.txt").readText())
//        customPassword.set("")
//        customKeyFile.set(file(System.getProperty("user.home") + "${File.separator}.ssh${File.separator}id_rsa"))
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

/*
task("loadKeyPassword") {
    scmVersion.repository.customKeyPassword.set("")
    // you can load the key from secure storage as well!
    scmVersion.repository.customKey.set(project.file("keys/id_ed25519").readText())
}

tasks.getByName("release") {
    dependsOn("loadKeyPassword")
}
*/

project.version = scmVersion.version

//allprojects {
//    project.version = scmVersion.version
//}

//task("loadGitHubToken") {
//    val credentials = file("github-axion-release-credentials.txt").readLines()
//    scmVersion.repository.customUsername.set(credentials[0])
//    scmVersion.repository.customPassword.set(credentials[1])
//}
