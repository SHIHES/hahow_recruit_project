package `in`.hahow.android_recruit_project.ui.util

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

fun String.getDiffDaysFromNowOrNull(): Int? {
    val now = Calendar.getInstance()
    val sdf = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault()).apply {
        timeZone = TimeZone.getTimeZone("UTC")
    }

    return try {
        val date = sdf.parse(this)
        val diffInMillis = date.time - now.timeInMillis
        val diffDays = (diffInMillis / (24 * 60 * 60 * 1000)).toInt()
        diffDays
    } catch (e: ParseException) {
        e.printStackTrace()
        null
    }
}