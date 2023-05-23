package `in`.hahow.android_recruit_project.ui.util

/*
    Identify string to Enum class safely
 */
inline fun <reified T : Enum<T>> enumOrNull(type: String?): T? {
    type ?: return null
    return try {
        java.lang.Enum.valueOf(T::class.java, type)
    } catch (e: Exception) {
        null
    }
}