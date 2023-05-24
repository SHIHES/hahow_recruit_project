object Dependencies {

    object AndroidX {
        const val coreKtx = "androidx.core:core-ktx:${Versions.Dependency.coreKtx}"
        const val appCompat = "androidx.appcompat:appcompat:${Versions.Dependency.appCompat}"
    }

    object UI {
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.Dependency.constraintLayout}"
        const val recyclerView = "androidx.recyclerview:recyclerview:${Versions.Dependency.recyclerView}"
        const val materialDesign = "com.google.android.material:material:${Versions.Dependency.materialDesign}"
    }

    object Test {
        const val junit = "junit:junit:${Versions.Dependency.junit}"
        const val junitExt = "androidx.test.ext:junit:${Versions.Dependency.junitExt}"
        const val expressoCore = "androidx.test.espresso:espresso-core:${Versions.Dependency.espresso}"
        const val mockkAndroid = "io.mockk:mockk-android:${Versions.Dependency.mockk}"
        const val mockkAgent = "io.mockk:mockk-agent:${Versions.Dependency.mockk}"
        const val mockkAndroidIt = "io.mockk:mockk-android:${Versions.Dependency.mockk}"
        const val mockkAgentIt = "io.mockk:mockk-agent:${Versions.Dependency.mockk}"
        const val hiltAndroidTest = "com.google.dagger:hilt-android-testing:${Versions.Dependency.hilt}"
        const val hiltCompilerTest = "com.google.dagger:hilt-compiler:${Versions.Dependency.hilt}"
    }

    object JetPack {
        const val viewModelLifecycle = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.Dependency.viewModel}"
        const val fragmentKtx = "androidx.fragment:fragment-ktx:${Versions.Dependency.fragment}"
        const val liveDataLifecycle = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.Dependency.liveData}"
    }

    object ThirdParty {
        const val glide = "com.github.bumptech.glide:glide:${Versions.Dependency.glide}"
        const val gson = "com.google.code.gson:gson:${Versions.Dependency.gson}"
        const val hiltAndroid = "com.google.dagger:hilt-android:${Versions.Dependency.hilt}"
        const val hiltCompiler = "com.google.dagger:hilt-compiler:${Versions.Dependency.hilt}"
    }

}