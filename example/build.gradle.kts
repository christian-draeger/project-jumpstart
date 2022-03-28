plugins {
    id("codes.draeger.jumpstart")
}

jumpstart {
    tag.set("Just trying this gradle plugin...")
    kotlin.set(true)
    junit.set(true)
    gitProperties.set(true)
    kover.set(true)
    testLogger.set(true)
    versionsUpdate.set(true)
}

// will inherit testlogger
testlogger {}
