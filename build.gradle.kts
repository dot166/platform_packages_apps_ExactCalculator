/*
 * SPDX-FileCopyrightText: 2023 The LineageOS Project
 * SPDX-License-Identifier: Apache-2.0
 */

plugins {
    id("com.android.application") version "8.13.1"
    id("org.jetbrains.kotlin.android") version "2.2.21"
}

android {
    compileSdk = 36
    namespace = "com.android.calculator2"

    defaultConfig {
        applicationId = "com.android.calculator2"
        minSdk = 31
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        getByName("release") {
            // Enables code shrinking, obfuscation, and optimization.
            isMinifyEnabled = true

            // Enables resource shrinking.
            isShrinkResources = true

            // Includes the default ProGuard rules files.
            setProguardFiles(
                listOf(
                    getDefaultProguardFile("proguard-android.txt"),
                    "proguard.flags"
                )
            )
        }
        getByName("debug") {
            // Append .dev to package name so we won't conflict with AOSP build.
            applicationIdSuffix = ".dev"
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    sourceSets {
        getByName("main") {
            res.srcDirs("res")
            java.srcDirs("src")
            manifest.srcFile("AndroidManifest.xml")
        }
    }
}

dependencies {
    implementation("io.github.dot166:j-Lib:104.0.7")
    implementation("com.hp:crcalc:1.0")
}
