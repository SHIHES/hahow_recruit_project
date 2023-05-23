package `in`.hahow.android_recruit_project.ui.main

import android.os.Bundle
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import `in`.hahow.android_recruit_project.R
import `in`.hahow.android_recruit_project.databinding.ActivityMainBinding
import `in`.hahow.android_recruit_project.ui.base.BaseActivity
import `in`.hahow.android_recruit_project.ui.base.BaseViewModel

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {

    private val viewModel: MainViewModel by viewModels()
    private val lessonModelModelAdapter = LessonModelModelAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun getViewModel(): BaseViewModel? = viewModel

    override fun initViewBinding(): ActivityMainBinding =
        ActivityMainBinding.inflate(layoutInflater)

    override fun initView(savedInstanceState: Bundle?) {
        binding?.apply {
            with(rvLessons) {
                adapter = lessonModelModelAdapter
            }

            viewModel.lessons.observe(this@MainActivity) {
                lessonModelModelAdapter.submitList(it)
            }
        }
    }
}