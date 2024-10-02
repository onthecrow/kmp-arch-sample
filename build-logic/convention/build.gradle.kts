import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    `kotlin-dsl`
}

group = "com.onthecrow.kmparchsample.buildlogic"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

kotlin {
    compilerOptions {
        jvmTarget = JvmTarget.JVM_17
    }
}

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("androidLibrary") {
            id = "plugin.onthecrow.android.library"
            implementationClass = "AndroidLibraryPlugin"
        }
        register("kotlinMultiplatformPlugin") {
            id = "plugin.onthecrow.multiplatform"
            implementationClass = "KotlinMultiplatformConventionPlugin"
        }
    }
}
