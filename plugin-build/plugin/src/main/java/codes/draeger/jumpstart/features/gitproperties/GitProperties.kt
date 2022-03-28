package codes.draeger.jumpstart.features.gitproperties

import codes.draeger.jumpstart.applyPlugin
import com.adarshr.gradle.testlogger.TestLoggerExtension
import com.adarshr.gradle.testlogger.theme.ThemeType
import com.gorylenko.GitPropertiesPluginExtension
import org.gradle.api.Project

fun Project.applyGitProperties(enabled: Boolean = true) {
    if (enabled) {
        allprojects {
            applyPlugin("com.gorylenko.gradle-git-properties")
            extensions.configure(GitPropertiesPluginExtension::class.java) {
                it.dateFormatTimeZone = "Europe/Berlin"
                it.failOnNoGitDirectory = false
            }
        }
    }
}
