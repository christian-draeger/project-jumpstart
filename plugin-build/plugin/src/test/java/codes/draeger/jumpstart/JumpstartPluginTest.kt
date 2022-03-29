package codes.draeger.jumpstart

import org.gradle.testfixtures.ProjectBuilder
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import java.io.File

@Disabled
class JumpstartPluginTest {

    @Test
    fun `plugin is applied correctly to the project`() {
        val project = ProjectBuilder.builder().build()
        project.pluginManager.apply("codes.draeger.jumpstart")

        assert(project.tasks.getByName("example") is ExampleTask)
    }

    @Test
    @Disabled
    fun `extension templateExampleConfig is created correctly`() {
        val project = ProjectBuilder.builder().build()
        project.pluginManager.apply("codes.draeger.jumpstart")

        assertNotNull(project.extensions.getByName("jumpstart"))
    }

    @Test
    fun `parameters are passed correctly from extension to task`() {
        val project = ProjectBuilder.builder().build()
        project.pluginManager.apply("codes.draeger.jumpstart")
        val aFile = File(project.projectDir, ".tmp")
        (project.extensions.getByName("jumpstart") as JumpstartExtension).apply {
            tag.set("a-sample-tag")
            outputFile.set(aFile)
        }

        val task = project.tasks.getByName("example") as ExampleTask

        assertEquals("a-sample-tag", task.tag.get())
        assertEquals("just-a-message", task.message.get())
        assertEquals(aFile, task.outputFile.get().asFile)
    }
}
