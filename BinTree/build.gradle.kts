import org.jetbrains.kotlin.gradle.utils.IMPLEMENTATION

plugins {
    kotlin("jvm")
}

group = "org.exampl"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation(project(":ITable"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}