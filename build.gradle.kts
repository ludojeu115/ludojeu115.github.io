import org.jetbrains.kotlin.gradle.targets.js.nodejs.NodeJsRootExtension

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
}
val copyResources = tasks.create("copyJsResourcesWorkaround", Copy::class.java) {
    from("src/jsMain/resources")
    into("build/distributions/resources")
}
afterEvaluate {
    project.tasks.getByName("build").finalizedBy(copyResources)
}

kotlin {
    js(IR) {
        moduleName = "portfolio"
        browser {
            commonWebpackConfig {
                outputFileName = "portfolio.js"
            }
        }
        binaries.executable()
    }
    sourceSets {
        commonMain.dependencies {
            implementation(compose.components.resources)
        }
        jsMain .dependencies {
            implementation(npm("highlight.js", "10.7.2"))
            implementation(compose.runtime)
            implementation(compose.html.core)
            implementation(compose.foundation)
            implementation(compose.material)
            implementation(compose.material3)
            implementation(compose.ui)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)
            implementation(libs.androidx.lifecycle.viewmodel)
            implementation(libs.androidx.lifecycle.runtime.compose)
        }
    }
}