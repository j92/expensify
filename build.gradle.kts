import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    application
    kotlin("jvm") version "1.4.10"
}

application {
    mainClass.set("com.joostvandriel.expensify.AppKt")
}

group = "org.expensify"
version = "1.0"

repositories {
    mavenCentral()
    maven(url = "https://kotlin.bintray.com/kotlinx")
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("org.jetbrains.kotlinx:kotlinx-cli:0.3")
    testImplementation(kotlin("test-common"))
    testImplementation(kotlin("test-junit"))
    testImplementation(kotlin("test-annotations-common"))
}

tasks.withType<KotlinCompile>().all {
    kotlinOptions {
        jvmTarget = "1.8"
        languageVersion = "1.4"
    }
}