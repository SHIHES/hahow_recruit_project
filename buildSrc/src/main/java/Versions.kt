object Versions {

    object Android {
        const val compileSdk = 33
        const val minSdk = 21
        const val targetSdk = 33
    }

    object App {
        const val applicationId = "in.hahow.android_recruit_project"
        const val versionCode = 1
        const val versionName = "1.0"
    }

    object Dependency {

        // androidx
        const val coreKtx = "1.3.2"
        const val appCompat = "1.2.0"

        // Test
        const val junit = "4.+"
        const val junitExt = "1.1.2"
        const val espresso = "3.3.0"
        const val mockk = "1.13.5"

        // Third party
        const val hilt = "2.44"
        const val gson = "2.10.1"
        const val glide = "4.15.1"

        // Life cycle aware
        const val viewModel = "2.5.1"
        const val fragment = "1.5.7"
        const val liveData = "2.5.1"

        // UI
        const val materialDesign = "1.10.0-alpha03"
        const val constraintLayout = "2.1.4"
        const val recyclerView = "1.2.1"
    }
}