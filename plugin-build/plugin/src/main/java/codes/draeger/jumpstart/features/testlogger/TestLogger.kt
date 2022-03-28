package codes.draeger.jumpstart.features.testlogger

import codes.draeger.jumpstart.applyPlugin
import com.adarshr.gradle.testlogger.TestLoggerExtension
import com.adarshr.gradle.testlogger.theme.ThemeType
import org.gradle.api.Project

fun Project.applyTestLogger(enabled: Boolean = true) {
    if (enabled) {
        applyPlugin("com.adarshr.test-logger")
        extensions.configure(TestLoggerExtension::class.java) {
            it.theme = ThemeType.MOCHA_PARALLEL
            @Suppress("MagicNumber")
            it.slowThreshold = 1000
        }
    }
}

data class JumpstartTestLoggerExtension(
    val enabled: Boolean = true
)
