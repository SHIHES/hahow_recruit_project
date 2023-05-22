package `in`.hahow.android_recruit_project.data.data_sourcce.local

import android.content.Context
import com.google.gson.Gson
import dagger.hilt.android.qualifiers.ApplicationContext
import `in`.hahow.android_recruit_project.R
import `in`.hahow.android_recruit_project.data.dto.LessonDto
import java.io.BufferedReader
import java.io.InputStreamReader
import javax.inject.Inject

/*
    Deal with all 'lessons' related behavior from local data source
 */
class LessonLocalDataSourceImpl @Inject constructor(
    @ApplicationContext private val applicationContext: Context,
    private val gson: Gson
) : LessonLocalDataSource {

    override suspend fun fetchLessons(): Result<LessonDto> {
        val inputStream = applicationContext.resources.openRawResource(R.raw.data)
        val bufferReader = BufferedReader(InputStreamReader(inputStream))

        return try {
            Result.success(gson.fromJson(bufferReader, LessonDto::class.java))
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}