plugins {
    id("org.jetbrains.kotlin.jvm") version "2.0.0-Beta1"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation(project(":common"))

    testImplementation(kotlin("test"))
    testImplementation("io.kotest:kotest-runner-junit5-jvm:5.8.0")
}

tasks.test {
    useJUnitPlatform()
}
