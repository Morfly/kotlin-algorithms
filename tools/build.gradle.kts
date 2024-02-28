import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm")
}

sourceSets {
    getByName("main") {
        kotlin.srcDir("src")
    }
}

tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions.freeCompilerArgs += "-Xallow-kotlin-package"
}

dependencies {
    implementation(libs.kotlin.reflect)
}