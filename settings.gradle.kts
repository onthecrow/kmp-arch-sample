enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
pluginManagement {
    includeBuild("build-logic")
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "kmp-arch-sample"
include(
    ":androidApp",
    ":shared",
    ":core:core",
    ":core:core-di",
    ":feature:feature1",
    ":feature:feature2",
    ":feature:feature3",
    ":feature:feature4",
    ":feature:feature5",
)
