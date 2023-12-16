plugins {
    kotlin("jvm")
}

sourceSets {
    getByName("main") {
        kotlin.srcDir("src")
    }
}

dependencies {
    implementation(libs.kotlin.reflect)
}