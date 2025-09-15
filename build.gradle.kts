// File ini ada di root project (satu level dengan settings.gradle.kts)
buildscript {
    dependencies {
        // Tambahkan classpath untuk Safe Args plugin
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:2.7.7")
    }
}

plugins {
    // Versi Gradle Android Plugin
    id("com.android.application") version "8.5.2" apply false
    id("org.jetbrains.kotlin.android") version "1.9.24" apply false
}
