import pl.allegro.tech.build.axion.release.domain.preRelease

plugins {
    // Gradle Release Plugin https://axion-release-plugin.readthedocs.io/en/latest/
    id("pl.allegro.tech.build.axion-release") version "1.14.2"
}

repositories {
    mavenCentral()
}

project.version = scmVersion.version

scmVersion {
    useHighestVersion.set(true)
    tag {
        prefix.set("v")
        versionSeparator.set("/")
        initialVersion({config, position -> "0.0.1"})
    }
    repository {
        type.set("git")
//        customKeyFile.set(file(System.getProperty("user.home") + "${File.separator}.ssh${File.separator}id_rsa"))
        customPassword.set("")
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

task("loadGitHubToken") {
    scmVersion.repository.customUsername.set(file("github-axion-release-token.txt").readText())
}