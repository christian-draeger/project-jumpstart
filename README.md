# Jumpstart 

## WIP 🚸

![Gradle Plugin Portal](https://img.shields.io/gradle-plugin-portal/v/codes.draeger.jumpstart?color=blue&logo=gradle)
[![Build](https://github.com/christian-draeger/project-jumpstart/actions/workflows/pre-merge.yaml/badge.svg)](https://github.com/christian-draeger/project-jumpstart/actions/workflows/pre-merge.yaml)
[![License](https://img.shields.io/github/license/cortinico/kotlin-android-template.svg)](LICENSE) 
![Language](https://img.shields.io/github/languages/top/cortinico/kotlin-android-template?color=blue&logo=kotlin)

A gradle convention plugin to jumpstart opinionated spring-boot projects written in kotlin by cutting down project configuration boilerplate in consuming projects.
It will allow users to start new projects quickly and convenient.

## How to use 👣

```kotlin 
plugins {
    id("codes.draeger.jumpstart")
}

jumpstart {
  // ...
}

```

## Features 🎨
### Test Runner
all gradle tasks of type `Test` will use Junit5 runner by default.

### Test Logger
apply testlogger to all projects

## Contributing 🤝

Feel free to open a issue or submit a pull request for any bugs/improvements.
