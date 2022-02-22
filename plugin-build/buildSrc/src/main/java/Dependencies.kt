object Versions {
    const val JUNIT = "5.5.2"
}

object BuildPluginsVersion {
    const val DETEKT = "1.19.0"
    const val KOTLIN = "1.4.32"
    const val KTLINT = "10.0.0"
    const val PLUGIN_PUBLISH = "0.14.0"
    const val VERSIONS_PLUGIN = "0.38.0"
}

object Lib {
    const val KOTLIN_PLUGIN = "org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.0"
    const val DETEKT = "io.gitlab.arturbosch.detekt:detekt-gradle-plugin:1.19.0"
    const val TEST_LOGGER = "com.adarshr:gradle-test-logger-plugin:3.1.0"
    const val VERSIONS_PLUGIN = "com.github.ben-manes:gradle-versions-plugin:0.38.0"
}

object TestingLib {
    const val JUNIT = "org.junit.jupiter:junit-jupiter:${Versions.JUNIT}"
}
