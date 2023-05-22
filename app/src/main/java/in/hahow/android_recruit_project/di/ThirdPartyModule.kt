package `in`.hahow.android_recruit_project.di

import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/*
    Use @Provides annotation to provide third party component
 */

@Module
@InstallIn(SingletonComponent::class)
object ThirdPartyModule {

    @Singleton
    @Provides
    fun provideGson(): Gson {
        return GsonBuilder()
            .setLenient()
            .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create()
    }
}