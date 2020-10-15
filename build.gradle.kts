// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    val kotlin_version = "1.3.72"

    repositories {
        google()
        jcenter()
    }

    dependencies {
        classpath ("com.android.tools.build:gradle:4.0.0")
        classpath ("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version")
    }
}

allprojects {
    repositories {
        google()
        jcenter()
    }
}

task ("clean") {
    delete(rootProject.buildDir)
}