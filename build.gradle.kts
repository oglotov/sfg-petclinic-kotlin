plugins {
    id("org.springframework.boot") version "3.0.0" apply false
    id("io.spring.dependency-management") version "1.1.0" apply false
    kotlin("jvm") version "1.7.21"
    kotlin("plugin.spring") version "1.7.21" apply false
    kotlin("plugin.jpa") version "1.7.21" apply false
}

allprojects {
    description = "Petclinic Kotlin Study Project"
    group = "ua.wwind.glotov"

    repositories {
        mavenCentral()
    }
}

