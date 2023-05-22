package `in`.hahow.android_recruit_project.data.repository

import `in`.hahow.android_recruit_project.data.data_sourcce.local.LessonLocalDataSource
import `in`.hahow.android_recruit_project.data.dto.LessonDto
import javax.inject.Inject

/*
    Collect all the 'lesson' related behavior from different data source
 */

class LessonRepositoryImpl @Inject constructor(
    private val lessonLocalDataSource: LessonLocalDataSource
) : LessonRepository {

    override suspend fun fetchLessons(): Result<LessonDto> {
        return lessonLocalDataSource.fetchLessons()
    }
}