package codes.draeger.jumpstart

import com.adarshr.gradle.testlogger.TestLoggerExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.ObjectConfigurationAction

const val EXTENSION_NAME = "jumpstartConfig"
const val TASK_NAME = "example"

abstract class JumpstartPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        // Add the 'template' extension object
        val extension = project.extensions.create(EXTENSION_NAME, JumpstartExtension::class.java, project)

        // Add a task that uses configuration from the extension object
        project.tasks.register(TASK_NAME, ExampleTask::class.java) {
            it.tag.set(extension.tag)
            it.message.set(extension.message)
            it.outputFile.set(extension.outputFile)
        }

        project.run {

            apply { action: ObjectConfigurationAction ->
                // action.plugin("org.jetbrains.kotlin.jvm")
                action.plugin("com.adarshr.test-logger")
                action.plugin("com.github.ben-manes.versions")
            }

            extensions.run {
                configure(TestLoggerExtension::class.java) {
                    it.setTheme("mocha-parallel")
                    @Suppress("MagicNumber")
                    it.slowThreshold = 1000
                }
            }

            /*afterEvaluate {
                if (extension.enableDetekt) {
                    it.applyDetekt()
                }
            }*/
        }

        fun Project.applyDetekt() {
            apply { it.plugin("io.gitlab.arturbosch.detekt") }
            // TODO; how to configure detekt
            println("detekt is enabled")
        }
    }
}
