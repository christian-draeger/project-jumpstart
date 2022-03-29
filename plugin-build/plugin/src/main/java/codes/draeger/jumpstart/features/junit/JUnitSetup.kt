package codes.draeger.jumpstart.features.junit

import org.gradle.api.Project
import org.gradle.api.tasks.testing.Test

fun Project.applyJUnit(enabled: Boolean = true) {
    if (enabled) {
        allprojects {
            dependencies.run {
                // how to apply dependency ???
                // add("test", "org.junit.jupiter:junit-jupiter:5.8.2")
                // create("org.junit.jupiter:junit-jupiter:5.8.2")
            }
            it.tasks.withType(Test::class.java).configureEach { test ->
                test.useJUnitPlatform()
            }
        }
    }

}
