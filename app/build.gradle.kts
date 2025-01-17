plugins {
    id("buildsrc.convention.kotlin-jvm")
    application
    alias(libs.plugins.kotlinSymbolProcessing.plugin)
}

dependencies {
    api(project(":processor"))
    ksp(project(":processor"))
}

application {
    mainClass = "by.siegell.caliper.AppKt"
}
