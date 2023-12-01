plugins {
    id("org.jetbrains.kotlin.jvm").version("1.3.72")
}

val test by tasks.getting(Test::class) {
    useJUnitPlatform { }
}

repositories {
    jcenter()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.slf4j:slf4j-simple:1.7.25")

    testCompile("io.kotlintest:kotlintest-runner-junit5:3.1.10")
}

