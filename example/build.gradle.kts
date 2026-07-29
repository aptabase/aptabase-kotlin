plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.aptabase.example"
    compileSdk = 37

    defaultConfig {
        applicationId = "com.aptabase.example"
        minSdk = 16
        targetSdk = 37
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro",
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    lint {
        abortOnError = false
    }
}

dependencies {
    implementation(project(":aptabase"))
    implementation(libs.androidx.appcompat)
    implementation(libs.google.material)
    implementation(libs.androidx.constraintlayout)
}
