plugins {
    id("buildsrc.convention.kotlin-jvm")
    application
    alias(libs.plugins.kotlinSymbolProcessing.plugin)
}

dependencies {
    implementation(libs.bundles.kotlinxEcosystem)

    api(project(":processor"))
    ksp(project(":processor"))

    api(project(":domain"))
}

application {
    mainClass = "by.siegell.caliper.AppKt"
}
