package `in`.hahow.android_recruit_project.data.data_sourcce.local

import `in`.hahow.android_recruit_project.data.dto.LessonDto

interface LessonLocalDataSource {

    suspend fun fetchLessons(): Result<LessonDto>
}