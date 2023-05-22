package `in`.hahow.android_recruit_project.data.repository

import `in`.hahow.android_recruit_project.data.dto.LessonDto

interface LessonRepository {

    suspend fun fetchLessons(): Result<LessonDto>
}