package `in`.hahow.android_recruit_project.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow

/*
    Deal with ViewModel event and set a reusable coroutine launcher
 */
open class BaseViewModel : ViewModel() {

    private val _viewEventSharedFlow = MutableSharedFlow<BaseViewEvent>()
    val viewEventSharedFlow: SharedFlow<BaseViewEvent> = _viewEventSharedFlow
    private var launchJob: Job? = null
    private val exceptionHandler = CoroutineExceptionHandler { _, exception ->
        sendViewEvent(BaseViewEvent.Error(exception))
    }

    /*
        The base coroutine scope to get all the base view event, change the isLazy property to
        change the initial coroutine state
     */
    fun launch(isLazy: Boolean = true, block: suspend CoroutineScope.() -> Unit): Job? {
        val coroutineStart = if (isLazy) CoroutineStart.LAZY else CoroutineStart.DEFAULT
        launchJob = viewModelScope.launch(exceptionHandler, start = coroutineStart) {
            sendViewEvent(BaseViewEvent.FullscreenLoading)
            block()
            sendViewEvent(BaseViewEvent.Done)
        }
        return launchJob
    }
    /*
        The BaseActivity will subscribe all the events at onCreate method
     */
    fun subscribeViewEvent(eventHandler: (event: BaseViewEvent) -> Unit) {
        viewModelScope.launch {
            launchJob?.start()
            viewEventSharedFlow.collect {
                eventHandler.invoke(it)
            }
        }
    }
    /*
        The only way to send the view event state to BaseActivity
     */
    fun sendViewEvent(viewEvent: BaseViewEvent) {
        viewModelScope.launch {
            _viewEventSharedFlow.emit(viewEvent)
        }
    }
}