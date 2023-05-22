package `in`.hahow.android_recruit_project.data.dto

data class LessonDto(
    val data: List<Data>
)

data class Data(
    val coverImageUrl: String,
    val numSoldTickets: Int,
    val proposalDueTime: String,
    val status: String,
    val successCriteria: SuccessCriteria,
    val title: String,
    val totalVideoLengthInSeconds: Int
)

data class SuccessCriteria(
    val numSoldTickets: Int
)