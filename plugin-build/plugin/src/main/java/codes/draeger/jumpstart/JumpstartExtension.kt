package codes.draeger.jumpstart

import codes.draeger.jumpstart.features.testlogger.JumpstartTestLoggerExtension
import org.gradle.api.Project
import org.gradle.api.file.RegularFileProperty
import org.gradle.api.provider.Property
import org.gradle.api.tasks.Optional
import javax.inject.Inject

const val DEFAULT_OUTPUT_FILE = "jumpstart-plugin.txt"

@Suppress("UnnecessaryAbstractClass")
abstract class JumpstartExtension @Inject constructor(project: Project) {

    private val objects = project.objects

    abstract val kotlin: Property<Boolean>
    abstract val junit: Property<Boolean>
    abstract val gitProperties: Property<Boolean>
    abstract val kover: Property<Boolean>
    abstract val testLogger: Property<Boolean>
    abstract val versionsUpdate: Property<Boolean>

    init {
        kotlin.convention(true)
        junit.convention(true)
        gitProperties.convention(true)
        kover.convention(true)
        testLogger.convention(true)
        versionsUpdate.convention(true)
    }

    @Optional
    val tag: Property<String> = objects.property(String::class.java)

    // Example of a property with a default set with .convention
    val outputFile: RegularFileProperty = objects.fileProperty().convention(
        project.layout.buildDirectory.file(DEFAULT_OUTPUT_FILE)
    )


    ////

    val testLoggerDisabled: Property<Boolean> = objects.property(Boolean::class.java)
    val testLoggerPlugin: Property<JumpstartTestLoggerExtension> = objects.property(JumpstartTestLoggerExtension::class.java)
}
