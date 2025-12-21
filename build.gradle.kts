plugins {
    kotlin("jvm") version "2.3.0"
}

group = "com.dvdmunckhof"
version = "2025"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}
