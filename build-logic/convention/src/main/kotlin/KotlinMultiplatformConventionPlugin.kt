import com.onthecrow.kmparchsample.buildlogic.configureKotlinJvm
import com.onthecrow.kmparchsample.buildlogic.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.getValue
import org.gradle.kotlin.dsl.getting
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

class KotlinMultiplatformConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) = with(target) {
        with(pluginManager) {
            apply("org.jetbrains.kotlin.multiplatform")
        }

        extensions.configure<KotlinMultiplatformExtension> {
            applyDefaultHierarchyTemplate()

            if (pluginManager.hasPlugin("com.android.library")) {
                androidTarget()
            }

            iosX64()
            iosArm64()
            iosSimulatorArm64()

            val commonMain by sourceSets.getting {
                dependencies {
                    implementation(project(":core:core-di"))
                    implementation(project(":core:core"))
                    implementation(libs.findLibrary("decompose").get())
                    implementation(libs.findLibrary("koin-core").get())
                    implementation(libs.findLibrary("kotlinx-coroutines-core").get())
                }
            }
            val commonTest by sourceSets.getting {
                dependencies {
                    implementation(kotlin("test"))
                }
            }
            val androidMain by sourceSets.getting
            val androidUnitTest by sourceSets.getting
            val iosX64Main by sourceSets.getting
            val iosArm64Main by sourceSets.getting
            val iosSimulatorArm64Main by sourceSets.getting
            val iosMain by sourceSets.getting {
                dependsOn(commonMain)
                iosX64Main.dependsOn(this)
                iosArm64Main.dependsOn(this)
                iosSimulatorArm64Main.dependsOn(this)
            }
            val iosX64Test by sourceSets.getting
            val iosArm64Test by sourceSets.getting
            val iosSimulatorArm64Test by sourceSets.getting
            val iosTest by sourceSets.getting {
                dependsOn(commonTest)
                iosX64Test.dependsOn(this)
                iosArm64Test.dependsOn(this)
                iosSimulatorArm64Test.dependsOn(this)
            }
        }

        configureKotlinJvm()
    }
}