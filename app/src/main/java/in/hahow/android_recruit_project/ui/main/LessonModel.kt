package `in`.hahow.android_recruit_project.ui.main

import `in`.hahow.android_recruit_project.data.dto.Lesson
import `in`.hahow.android_recruit_project.ui.util.enumOrNull
import `in`.hahow.android_recruit_project.ui.util.getDiffDaysFromNowOrNull

data class LessonModel(
    val title: String? = null,
    val imageUrl: String? = null,
    val status: LessonStatus? = null,
    val successCriteriaNumber: Int? = null,
    val soldTicketsNumber: Int? = null,
    val proposalDueTime: Int? = null
) {
    enum class LessonStatus(val value: String) {
        INCUBATING("募資中"),
        PUBLISHED("已開課"),
        SUCCESS("募資成功")
    }
}

fun Lesson.mappingLessonModel(): LessonModel {
    return LessonModel(
        title = this.title,
        imageUrl = this.coverImageUrl,
        status = enumOrNull<LessonModel.LessonStatus>(this.status),
        successCriteriaNumber = this.successCriteria?.numSoldTickets ?: 0,
        soldTicketsNumber = this.numSoldTickets,
        proposalDueTime = this.proposalDueTime?.getDiffDaysFromNowOrNull()
    )
}