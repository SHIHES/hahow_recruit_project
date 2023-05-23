package `in`.hahow.android_recruit_project.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import `in`.hahow.android_recruit_project.data.data_sourcce.local.LessonLocalDataSource
import `in`.hahow.android_recruit_project.data.data_sourcce.local.LessonLocalDataSourceImpl

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {

    @Binds
    abstract fun bindLessonLocalDataSource(lessonLocalDataSourceImpl: LessonLocalDataSourceImpl): LessonLocalDataSource
}