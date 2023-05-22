package `in`.hahow.android_recruit_project.ui.base

sealed class BaseViewEvent {

    object FullscreenLoading : BaseViewEvent()

    class Error(val throwable: Throwable) : BaseViewEvent()

    object Done : BaseViewEvent()

    // For Data event
    class ViewEventData<T>(val data: T? = null) : BaseViewEvent()
}