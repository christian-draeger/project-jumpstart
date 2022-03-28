package codes.draeger.jumpstart.features.kotlin

import codes.draeger.jumpstart.applyPlugin
import org.gradle.api.Project
import org.gradle.api.tasks.compile.JavaCompile
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

fun Project.applyKotlinJvm(enabled: Boolean = true) {
    if (enabled) {
        allprojects {
            applyPlugin("org.jetbrains.kotlin.jvm")
//            dependencies.run {
//                add("default", "org.jetbrains.kotlin:kotlin-reflect:1.6.10")
//            }

            it.tasks.withType(JavaCompile::class.java).configureEach { javaCompile ->
                javaCompile.options.encoding = "UTF-8"
            }

            it.tasks.withType(KotlinCompile::class.java).configureEach { kotlinCompile ->
                kotlinCompile.kotlinOptions.apply {
                    jvmTarget = "1.8"
                    freeCompilerArgs = listOf("-Xjsr305=strict")
                    apiVersion = "1.4"
                    languageVersion = "1.4"
                }
            }
        }
    }
}
