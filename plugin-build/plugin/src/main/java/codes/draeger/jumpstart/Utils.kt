package codes.draeger.jumpstart

import org.gradle.api.Project
import org.gradle.api.plugins.ObjectConfigurationAction

fun Project.applyPlugin(pluginId: String) {
    apply { action: ObjectConfigurationAction ->
        action.plugin(pluginId)
    }
}
