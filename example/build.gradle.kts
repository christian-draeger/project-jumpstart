plugins {
    java
    id("codes.draeger.jumpstart")
}

jumpstart {
    message.set("Just trying this gradle plugin...")
}

// will inherit testlogger
testlogger {}
