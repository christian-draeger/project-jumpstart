pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
    }
}

rootProject.name = ("jumpstart")

include(":example")
includeBuild("plugin-build")
