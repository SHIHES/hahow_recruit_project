package `in`.hahow.android_recruit_project.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import `in`.hahow.android_recruit_project.data.repository.LessonRepository
import `in`.hahow.android_recruit_project.data.repository.LessonRepositoryImpl

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindLessonRepository(lessonRepositoryImpl: LessonRepositoryImpl): LessonRepository
}