plugins {
    id("codes.draeger.jumpstart")
}

jumpstart {
    tag.set("Just trying this gradle plugin...")

    // defaults to true
//    kotlin.set(true)
//    junit.set(true)
//    gitProperties.set(true)
//    kover.set(true)
//    testLogger.set(true)
//    versionsUpdate.set(true)
}

// will inherit plugins by default
kotlin {}
testlogger {}
gitProperties {}
// kover {}

tasks {
    // will add provided tasks
    withType<com.github.benmanes.gradle.versions.updates.DependencyUpdatesTask>()
}
