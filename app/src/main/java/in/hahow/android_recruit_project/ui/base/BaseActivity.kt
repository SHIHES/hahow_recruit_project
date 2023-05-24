package `in`.hahow.android_recruit_project.ui.base

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.google.android.material.snackbar.Snackbar

/*
    Observe BaseViewEvent to determine the progress bar display or not
 */
abstract class BaseActivity<VB : ViewBinding> : AppCompatActivity() {

    protected var binding: VB? = null
        private set
    private val loadDialog = LoadingDialogFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = initViewBinding().apply {
            setContentView(root)
        }
        getViewModel()?.subscribeViewEvent(this::handleViewEvent)
        initView(savedInstanceState)
    }

    protected open fun handleViewEvent(event: BaseViewEvent) {
        when (event) {
            is BaseViewEvent.FullscreenLoading -> {
                showDialog(loadDialog)
            }

            is BaseViewEvent.Done -> {
                dismissDialog(loadDialog)
            }

            is BaseViewEvent.Error -> {
                binding?.let {
                    Snackbar.make(
                        it.root, event.throwable.toString(), Snackbar.LENGTH_LONG
                    )
                        .setBackgroundTint(Color.BLACK)
                        .setTextColor(Color.WHITE)
                        .show()
                }
            }

            else -> {

            }
        }
    }

    protected abstract fun getViewModel(): BaseViewModel?

    protected abstract fun initViewBinding(): VB

    protected abstract fun initView(savedInstanceState: Bundle?)

    private fun showDialog(dialogFragment: DialogFragment) {
        val fm = supportFragmentManager
        val tagName = dialogFragment.javaClass.name
        if (fm.isStateSaved || fm.isDestroyed) {
            return
        }
        if (findFragmentByTag(tagName) == null &&
            getVisibleFragment() == null
        ) {
            dialogFragment.showNow(fm, tagName)
        }
    }

    private fun dismissDialog(dialogFragment: DialogFragment) {
        val tagName = dialogFragment.javaClass.name
        if (findFragmentByTag(tagName) != null)
            dialogFragment.dismiss()
    }

    private fun getVisibleFragmentByTag(tag: String): Fragment? {
        return supportFragmentManager.fragments.firstOrNull {
            it.tag?.contains(tag) == true && it.isAdded && it.isVisible
        }
    }

    private fun getVisibleFragment(): Fragment? {
        return supportFragmentManager.fragments.firstOrNull { it.isAdded && it.isVisible }
    }

    private fun findFragmentByTag(tag: String?): Fragment? {
        return supportFragmentManager.findFragmentByTag(tag)
    }
}