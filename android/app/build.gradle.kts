plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.eugene373.extremetuxracer"
    compileSdk = 36

    defaultConfig {
        resValue("string", "app_name", "Extreme Tux Racer")

        applicationId = "com.eugene373.extremetuxracer"
        versionCode = 7
        versionName = "0.8.107"

        minSdk = 23
        targetSdk = 36

        manifestPlaceholders["androidAppLibName"] = "extremetuxracer"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        debug {
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }

    kotlinOptions {
        jvmTarget = "21"
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.15.0")
    implementation("androidx.appcompat:appcompat:1.7.0")
}
