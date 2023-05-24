plugins {
    id ("com.android.application")
    id ("kotlin-android")
    id ("kotlin-kapt")
    id ("com.google.dagger.hilt.android")
}

android {
    compileSdk = Versions.Android.compileSdk

    defaultConfig {
        applicationId = Versions.App.applicationId
        minSdk = Versions.Android.minSdk
        targetSdk = Versions.Android.targetSdk
        versionCode = Versions.App.versionCode
        versionName = Versions.App.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        debug {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        viewBinding = true
    }
}

kapt {
    correctErrorTypes = true
}

dependencies {

    // Core
    implementation (Dependencies.AndroidX.coreKtx)
    implementation (Dependencies.AndroidX.appCompat)

    // UI
    implementation (Dependencies.UI.constraintLayout)
    implementation (Dependencies.UI.recyclerView)
    implementation (Dependencies.UI.materialDesign)

    // Hilt
    implementation (Dependencies.ThirdParty.hiltAndroid)
    kapt (Dependencies.ThirdParty.hiltCompiler)

    // ViewModel
    implementation (Dependencies.JetPack.viewModelLifecycle)

    // Fragment
    implementation (Dependencies.JetPack.fragmentKtx)

    // LiveData
    implementation (Dependencies.JetPack.liveDataLifecycle)

    // Glide
    implementation (Dependencies.ThirdParty.glide)

    // Gson
    implementation (Dependencies.ThirdParty.gson)

    // Junit
    testImplementation (Dependencies.Test.junit)
    androidTestImplementation (Dependencies.Test.junitExt)

    // Espresso
    androidTestImplementation (Dependencies.Test.expressoCore)

    // Mockk
    testImplementation (Dependencies.Test.mockkAndroid)
    testImplementation (Dependencies.Test.mockkAgent)
    androidTestImplementation (Dependencies.Test.mockkAndroidIt)
    androidTestImplementation (Dependencies.Test.mockkAgentIt)

    // Hilt test
    testImplementation (Dependencies.Test.hiltAndroidTest)
    kaptTest (Dependencies.Test.hiltCompilerTest)
}
