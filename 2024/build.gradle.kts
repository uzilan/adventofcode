plugins {
    alias(libs.plugins.kotlin.jvm)
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(platform(libs.kotlin.bom))
    implementation(libs.kotlin.stdlib.jdk8)
    implementation(project(":common"))

    testImplementation(kotlin("test"))
    testImplementation(libs.kotest)
}

tasks.test {
    useJUnitPlatform()
}
