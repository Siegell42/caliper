plugins {
    id("buildsrc.convention.kotlin-jvm")
}

dependencies {
    implementation(libs.bundles.kotlinxEcosystem)

    implementation(libs.kotlinSymbolProcessing.api)
    implementation(project(":domain"))
}