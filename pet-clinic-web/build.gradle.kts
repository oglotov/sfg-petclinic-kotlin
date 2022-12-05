import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot")
    id("io.spring.dependency-management")
    kotlin("jvm")
    kotlin("plugin.spring")
}

kotlin {
    jvmToolchain(17)
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}

dependencies {

    // Kotlin
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    // Actuator
    implementation("org.springframework.boot:spring-boot-starter-actuator")

    // WEB
    implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
    implementation("org.springframework.boot:spring-boot-starter-web")

    // Cache
    implementation("javax.cache:cache-api")

    // WebJars
    implementation("org.webjars:webjars-locator-core")
    implementation("org.webjars.npm:bootstrap:5.2.3")
    implementation("org.webjars.npm:font-awesome:4.7.0")

    // PetClinic Data module
    implementation(project(":pet-clinic-data"))

    // DevTools
    developmentOnly("org.springframework.boot:spring-boot-devtools")

    // Logging
    implementation("io.github.microutils:kotlin-logging-jvm:3.0.4")
    implementation(group = "ch.qos.logback", name = "logback-classic", version = "1.2.9")

    // Testing
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.0")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.9.0")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "17"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}