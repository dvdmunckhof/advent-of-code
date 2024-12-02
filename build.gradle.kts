plugins {
    kotlin("jvm") version "2.1.0"
}

group = "com.dvdmunckhof"
version = "2024"

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
    jvmToolchain(17)
}
