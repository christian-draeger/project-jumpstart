package codes.draeger.jumpstart.features.kover

import codes.draeger.jumpstart.applyPlugin
import org.gradle.api.Project
import org.gradle.api.tasks.testing.Test

// import kotlinx.kover.api.KoverTaskExtension

fun Project.applyKover(enabled: Boolean = true) {
    if (enabled) {
        applyPlugin("org.jetbrains.kotlinx.kover")
        allprojects {
            it.tasks.withType(Test::class.java).configureEach { test ->
                test.finalizedBy("koverReport", "koverCollectReports")
            }
        }
    }
}
