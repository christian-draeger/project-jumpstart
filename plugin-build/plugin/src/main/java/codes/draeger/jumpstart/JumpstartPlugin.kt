package codes.draeger.jumpstart

import codes.draeger.jumpstart.features.gitproperties.applyGitProperties
import codes.draeger.jumpstart.features.junit.applyJUnit
import codes.draeger.jumpstart.features.kotlin.applyKotlinJvm
import codes.draeger.jumpstart.features.kover.applyKover
import codes.draeger.jumpstart.features.testlogger.applyTestLogger
import codes.draeger.jumpstart.features.versionsupdate.applyVersionUpdates
import org.gradle.api.Plugin
import org.gradle.api.Project

const val EXTENSION_NAME = "jumpstart"
const val TASK_NAME = "example"

abstract class JumpstartPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        // Add the 'template' extension object
        val extension = project.extensions.create(EXTENSION_NAME, JumpstartExtension::class.java, project)

        // Add a task that uses configuration from the extension object
        project.tasks.register(TASK_NAME, ExampleTask::class.java) {
            it.tag.set(extension.tag)
            it.outputFile.set(extension.outputFile)
        }

        project.run {
            applyKotlinJvm(extension.kotlin.get())
            applyTestLogger(extension.testLogger.get())
            applyJUnit(extension.junit.get())
            applyGitProperties(extension.gitProperties.get())
            applyVersionUpdates(extension.versionsUpdate.get())
            applyKover(extension.kover.get())
        }
    }
}
