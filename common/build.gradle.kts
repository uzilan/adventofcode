plugins {
    alias(libs.plugins.kotlin.jvm)
    `kotlin-dsl`
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(platform(libs.kotlin.bom))
    implementation(libs.kotlin.stdlib.jdk8)
}


abstract class CreateDay : DefaultTask() {

    @Input
    val year = 2024

    @TaskAction
    fun createDay() {
        val code = "$year/src/main/kotlin/adventofcode"
        val test = "$year/src/test/kotlin/adventofcode"
        val sources = "$year/src/main/resources"
        val testSources = "$year/src/test/resources"

        val nextDay = (File(code).listFiles()
            .maxOfOrNull { file -> file.nameWithoutExtension.drop(3).toInt() } ?: 0) + 1

        val day = File("$code/Day$nextDay.kt")
        File("template/Day.kt").copyTo(day)
        day.writeText(day.readText().replace("DayX", "Day$nextDay"))

        val dayTest = File("$test/Day${nextDay}Test.kt")
        File("template/DayTest.kt").copyTo(dayTest)
        dayTest.writeText(dayTest.readText().replace("DayX", "Day$nextDay"))

        File("$sources/Day$nextDay.txt").createNewFile()

        File("$testSources/Day${nextDay}Test.txt").createNewFile()
    }
}

tasks.register<CreateDay>("createDay") {
    group = "adventofcode"
}
