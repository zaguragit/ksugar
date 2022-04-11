plugins {
    kotlin("jvm") version "1.6.20"
    `maven-publish`
}

group = "io.posidon"
version = "22.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib")
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            artifactId = "library"
            from(components["kotlin"])
        }
    }
}