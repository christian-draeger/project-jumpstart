plugins {
    kotlin("jvm")
    id("java-gradle-plugin")
    id("com.gradle.plugin-publish")
}

repositories {
    mavenCentral()
    maven {
        url = uri("https://plugins.gradle.org/m2/")
    }
}

dependencies {
    implementation(gradleApi())

    // kotlin
    // implementation(kotlin("stdlib-jdk8"))
    // implementation(kotlin("reflect"))
    implementation(Lib.KOTLIN_PLUGIN)

    // third party
    implementation(Lib.DETEKT)
    implementation(Lib.VERSIONS_PLUGIN)
    implementation(ThirdParty.Plugins.TEST_LOGGER_PLUGIN)
    implementation(ThirdParty.Plugins.SpringBoot.GRADLE_PLUGIN)
    implementation(ThirdParty.Plugins.GIT_PROPERTIES_PLUGIN)
    implementation(ThirdParty.Plugins.KOVER)

    testImplementation(ThirdParty.Libs.Testing.JUNIT)
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

val releaseVersion = rootProject.property("releaseVersion").toString()

gradlePlugin {
    plugins {
        create(PluginCoordinates.ID) {
            id = PluginCoordinates.ID
            implementationClass = PluginCoordinates.IMPLEMENTATION_CLASS
            version = releaseVersion
        }
    }
}

// Configuration Block for the Plugin Marker artifact on Plugin Central
pluginBundle {
    website = PluginBundle.WEBSITE
    vcsUrl = PluginBundle.VCS
    description = PluginBundle.DESCRIPTION
    tags = PluginBundle.TAGS

    plugins {
        getByName(PluginCoordinates.ID) {
            displayName = PluginBundle.DISPLAY_NAME
        }
    }

    mavenCoordinates {
        groupId = PluginCoordinates.GROUP
        artifactId = PluginCoordinates.ID
        version = releaseVersion
    }
}

tasks.create("setupPluginUploadFromEnvironment") {
    doLast {
        val key = System.getenv("GRADLE_PUBLISH_KEY")
        val secret = System.getenv("GRADLE_PUBLISH_SECRET")

        if (key == null || secret == null) {
            throw GradleException("gradlePublishKey and/or gradlePublishSecret are not defined environment variables")
        }

        System.setProperty("gradle.publish.key", key)
        System.setProperty("gradle.publish.secret", secret)
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
