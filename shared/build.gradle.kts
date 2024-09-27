plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.kotlinCocoapods)
    alias(libs.plugins.androidLibrary)
    id("kotlinx-serialization")
}

kotlin {
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }
    iosX64()
    iosArm64()
    iosSimulatorArm64()

    cocoapods {
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        version = "1.0.0"
        ios.deploymentTarget = "15.0"
        podfile = project.file("../iosApp/Podfile")
        framework {
            baseName = "shared"
            isStatic = true
            export(libs.decompose)
            export(libs.essenty)
            export(projects.core)
            export(projects.feature.feature1)
            export(projects.feature.feature2)
            export(projects.feature.feature3)
            export(projects.feature.feature4)
            export(projects.feature.feature5)
        }
    }
    
    sourceSets {
        commonMain.dependencies {
            api(projects.core.core)
            api(projects.core.coreDi)
            api(projects.feature.feature1)
            api(projects.feature.feature2)
            api(projects.feature.feature3)
            api(projects.feature.feature4)
            api(projects.feature.feature5)
            implementation(libs.decompose)
            implementation(libs.koin.core)
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }
}

android {
    namespace = "com.onthecrow.kmparchsample"
    compileSdk = 34
    defaultConfig {
        minSdk = 26
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}