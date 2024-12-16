
import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
    alias(libs.plugins.sqldelight)
}

kotlin {
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "11"
            }
        }
    }
    
    jvm("desktop")

    sqldelight {
        databases {
            create("AppDatabase") {
                packageName.set("org.shettyyttehs.counter.cache")
            }
        }
    }

    sourceSets {
        val desktopMain by getting
        
        androidMain.dependencies {
            // wizard default dependencies
            implementation(compose.preview)
            implementation(libs.androidx.activity.compose)

            // sqlDelight
            implementation(libs.sqldelight.android)
        }
        commonMain.dependencies {
            // wizard default dependencies
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.ui)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)
            implementation(libs.androidx.lifecycle.viewmodel)
            implementation(libs.androidx.lifecycle.runtime.compose)

            // material3
            implementation(libs.material3)
            // navigation
            implementation(libs.navigation.compose)
            // sqlDelight
            implementation(libs.sqldelight.coroutine)
            // lifecycle-viewmodel-compose
            implementation(libs.lifecycle.viewmodel.compose)
        }
        desktopMain.dependencies {
            implementation(compose.desktop.currentOs)
            implementation(libs.kotlinx.coroutines.swing)

            // sqlDelight
            implementation(libs.sqldelight.jvm)
        }
    }
}

android {
    namespace = "org.shettyyttehs.counter"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    defaultConfig {
        applicationId = "org.shettyyttehs.counter"
        minSdk = libs.versions.android.minSdk.get().toInt()
        targetSdk = libs.versions.android.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    debugImplementation(compose.uiTooling)
}

compose.desktop {
    application {
        mainClass = "org.shettyyttehs.counter.MainKt"

        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "org.shettyyttehs.counter"
            packageVersion = "1.0.0"
        }
    }
}
