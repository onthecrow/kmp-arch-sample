package com.onthecrow.kmparchsample.buildlogic

import com.android.build.gradle.BaseExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

fun Project.configureAndroid() {
  android {
    compileSdkVersion(Versions.COMPILE_SDK)

    defaultConfig {
      minSdk = Versions.MIN_SDK
      targetSdk = Versions.TARGET_SDK
    }

    compileOptions {
      sourceCompatibility = JavaVersion.VERSION_17
      targetCompatibility = JavaVersion.VERSION_17
    }

    packagingOptions {
      resources {
        excludes +=  "/META-INF/{AL2.0,LGPL2.1}"
      }
    }
  }
}

fun Project.android(action: BaseExtension.() -> Unit) = extensions.configure<BaseExtension>(action)

