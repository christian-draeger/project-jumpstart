package codes.draeger.jumpstart.features.versionsupdate

import codes.draeger.jumpstart.applyPlugin
import com.github.benmanes.gradle.versions.updates.DependencyUpdatesTask
import org.gradle.api.Project
import java.util.Locale

fun Project.applyVersionUpdates(enabled: Boolean = true) {
    if (enabled) {
        allprojects {
            applyPlugin("com.github.ben-manes.versions")
            tasks.withType(DependencyUpdatesTask::class.java) { dependencyUpdatesTask ->
                dependencyUpdatesTask.rejectVersionIf {
                    isNonStable(it.candidate.version)
                }
            }
        }
    }
}

private fun isNonStable(version: String): Boolean {
    val stableKeyword = listOf("RELEASE", "FINAL", "GA").any { version.uppercase().contains(it) }
    val regex = "^[0-9,.v-]+(-r)?$".toRegex()
    val isStable = stableKeyword || regex.matches(version)
    return isStable.not()
}
