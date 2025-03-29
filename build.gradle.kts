plugins {
    kotlin("jvm") version "2.0.21"
}

group = "org.exampl"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":BinTree"))
    testImplementation("org.testng:testng:7.8.0") // Проверьте актуальную версию на Maven Central
}

// Новый способ настройки TestNG (рекомендуется для Gradle 8.10+)
testing {
    suites {
        val test by getting(JvmTestSuite::class) {
            // Указываем, что используем TestNG вместо JUnit
            useTestNG()
        }
    }
}

// Старый способ (работает, но будет удален в Gradle 9.0)
tasks.named<Test>("test") {
    useTestNG() // Оставьте, если нужна совместимость со старыми версиями
}
kotlin {
    jvmToolchain(21)
}