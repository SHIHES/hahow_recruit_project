package `in`.hahow.android_recruit_project.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import `in`.hahow.android_recruit_project.data.repository.LessonRepository
import `in`.hahow.android_recruit_project.ui.base.BaseViewEvent
import `in`.hahow.android_recruit_project.ui.base.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val lessonRepository: LessonRepository
) : BaseViewModel() {

    private val _lessons = MutableLiveData<List<LessonModel>>()
    val lessons: LiveData<List<LessonModel>> = _lessons

    init {
        getLessons()
    }

    private fun getLessons() {
        launch(false) {
            val data = lessonRepository.fetchLessons()
            data.onSuccess { lessonDto ->
                _lessons.value = lessonDto.lessons.map {
                    it.mappingLessonModel()
                }
            }.onFailure {
                sendViewEvent(BaseViewEvent.Error(it))
            }
        }
    }
}