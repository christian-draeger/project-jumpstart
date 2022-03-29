object Versions {
    const val JUNIT = "5.5.2"
    const val SPRING_BOOT = "2.6.3"
    const val SPRING_DOC = "1.6.2"
    const val HTML_DSL = "0.7.3"
    const val MOCKK = "1.12.1"
    const val STRIKT = "0.33.0"
    const val REST_ASSURED = "4.4.0"
}

// used by the build of the plugin itself
object BuildPluginsVersion {
    const val DETEKT = "1.19.0"
    const val KOTLIN = "1.6.10"
    const val KTLINT = "10.0.0"
    const val PLUGIN_PUBLISH = "0.14.0"
    const val VERSIONS_PLUGIN = "0.38.0"
}

object Lib {
    const val KOTLIN_PLUGIN = "org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.0"
    const val DETEKT = "io.gitlab.arturbosch.detekt:detekt-gradle-plugin:1.19.0"
    const val VERSIONS_PLUGIN = "com.github.ben-manes:gradle-versions-plugin:0.42.0"
}

object ThirdParty {
    object Plugins {
        const val TEST_LOGGER_PLUGIN = "com.adarshr:gradle-test-logger-plugin:3.1.0"
        const val GIT_PROPERTIES_PLUGIN = "com.gorylenko.gradle-git-properties:gradle-git-properties:2.3.2"
        const val TEST_SETS = "org.unbroken-dome.test-sets:4.0.0"
        const val DOCKER_SPRING_BOOT = "com.bmuschko.docker-spring-boot-application:7.1.0"
        object SpringBoot {
            const val GRADLE_PLUGIN = "org.springframework.boot:spring-boot-gradle-plugin:${Versions.SPRING_BOOT}"
        }
        const val KOVER = "org.jetbrains.kotlinx.kover:org.jetbrains.kotlinx.kover.gradle.plugin:0.5.0-RC2"
    }
    object Libs {
        const val SPRING_DOC_OPEN_API_UI = "org.springdoc:springdoc-openapi-ui:${Versions.SPRING_DOC}"
        const val SPRING_DOC_OPEN_API_KOTLIN = "org.springdoc:springdoc-openapi-kotlin:${Versions.SPRING_DOC}"
        const val KOTLIN_HTML_DSL = "org.jetbrains.kotlinx:kotlinx-html-jvm:${Versions.HTML_DSL}"

        object Testing {
            const val JUNIT = "org.junit.jupiter:junit-jupiter:${Versions.JUNIT}"
            const val MOCKK = "io.mockk:mockk:${Versions.MOCKK}"
            const val STRIKT = "io.strikt:strikt-core:${Versions.STRIKT}"
            const val REST_ASSURED = "io.rest-assured:kotlin-extensions:${Versions.REST_ASSURED}"
        }
    }
}
