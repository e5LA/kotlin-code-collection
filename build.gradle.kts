plugins {
    kotlin("jvm") version "2.2.21"
    id("org.jlleitschuh.gradle.ktlint") version "14.0.1"
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.named("check") {
    dependsOn("ktlintCheck")
}

tasks.test {
    useJUnitPlatform()
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}
