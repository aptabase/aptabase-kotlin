plugins {
    alias(libs.plugins.android.library)
    id("maven-publish")
}

val sdkVersion = "0.1.0"
version = sdkVersion

android {
    namespace = "com.aptabase"
    compileSdk = 37

    buildFeatures {
        buildConfig = true
    }

    defaultConfig {
        minSdk = 16
        buildConfigField("String", "SDK_VERSION", "\"aptabase-kotlin@$sdkVersion\"")

        aarMetadata {
            minCompileSdk = 28
        }

        consumerProguardFiles("consumer-rules.pro")
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    publishing {
        singleVariant("release") {
            withSourcesJar()
        }
    }
}

afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("release") {
                from(components["release"])
                groupId = "com.github.aptabase"
                artifactId = "aptabase-kotlin"
                version = project.version.toString()
            }
        }
    }
}
