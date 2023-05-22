package `in`.hahow.android_recruit_project

import android.app.Application
import com.google.android.material.color.DynamicColors
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class ProjectApplication : Application(){

    override fun onCreate() {
        super.onCreate()
        // Provide 5 random themes each time
        DynamicColors.applyToActivitiesIfAvailable(this)
    }
}