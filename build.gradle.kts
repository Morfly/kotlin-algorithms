plugins {
    alias(libs.plugins.kotlin.jvm)
}

sourceSets {
    getByName("main") {
        kotlin.srcDir("src")
    }
}

dependencies {
    implementation(projects.tools)

    implementation(libs.kotlin.coroutines)
}
