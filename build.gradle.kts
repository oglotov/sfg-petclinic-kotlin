plugins {
    // Gradle Release Plugin
    id("net.researchgate.release") version "3.0.2"
}

version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
}

allprojects {
    apply(plugin = "net.researchgate.release")
}