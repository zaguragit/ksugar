plugins {
    id("org.jetbrains.kotlin.jvm") version "1.6.20"
}

group = "io.posidon.kotlin"
version = "22.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib")
}