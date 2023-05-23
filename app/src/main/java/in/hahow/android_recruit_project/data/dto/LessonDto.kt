package `in`.hahow.android_recruit_project.data.dto

import com.google.gson.annotations.SerializedName

data class LessonDto(
    @SerializedName("data") val lessons: List<Lesson>
)

data class Lesson(
    val coverImageUrl: String? = null,
    val numSoldTickets: Int? = null,
    val proposalDueTime: String? = null,
    val status: String? = null,
    val successCriteria: SuccessCriteria? = null,
    val title: String? = null,
    val totalVideoLengthInSeconds: Int? = null
)

data class SuccessCriteria(
    val numSoldTickets: Int? = null
)