plugins {
    // Gradle Release Plugin
    id("net.researchgate.release") version "3.0.2" apply false
}

repositories {
    mavenCentral()
}

allprojects {
    apply(plugin = "net.researchgate.release")
}