import com.android.build.gradle.LibraryExtension
import com.onthecrow.kmparchsample.buildlogic.configureKotlinJvm
import com.onthecrow.kmparchsample.buildlogic.Versions
import com.onthecrow.kmparchsample.buildlogic.configureAndroid
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class AndroidLibraryPlugin : Plugin<Project> {
  override fun apply(target: Project) {
    with(target) {
      with(pluginManager) {
        apply("com.android.library")
      }

      extensions.configure<LibraryExtension> {

        defaultConfig.targetSdk = Versions.TARGET_SDK

        configureKotlinJvm()
        configureAndroid()
      }
    }
  }
}
