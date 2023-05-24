package `in`.hahow.android_recruit_project.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import `in`.hahow.android_recruit_project.R
import `in`.hahow.android_recruit_project.databinding.CellLessonBinding

/*
    RecyclerView Adapter for LessonModel, set a new view type holder before you add a new lesson
    status
 */
class LessonModelModelAdapter :
    ListAdapter<LessonModel, RecyclerView.ViewHolder>(DiffCallback()) {

    val requestOption = RequestOptions()
        .placeholder(R.drawable.baseline_cloud_download_24)
        .error(R.drawable.baseline_error_24)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            VIEW_TYPE_LESSON_SUCCESS -> {
                SuccessViewHolder(
                    CellLessonBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
            else -> {
                WaitingViewHolder(
                    CellLessonBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position).status) {
            LessonModel.LessonStatus.SUCCESS -> VIEW_TYPE_LESSON_SUCCESS
            LessonModel.LessonStatus.PUBLISHED -> VIEW_TYPE_LESSON_SUCCESS
            else -> VIEW_TYPE_LESSON_WAITING
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is SuccessViewHolder -> {
                holder.onBind(getItem(position))
            }
            is WaitingViewHolder -> {
                holder.onBind(getItem(position))
            }
        }
    }

    inner class SuccessViewHolder(private val binding: CellLessonBinding) :
        BaseLessonViewHolder(binding) {

        override fun onBind(item: LessonModel) {
            super.onBind(item)
            val color = ContextCompat.getColor(itemView.context, R.color.lesson_status_success)

            binding.apply {
                with(tvCellLessonStatus) {
                    text = item.status?.value
                    setBackgroundColor(color)
                }
                with(tvCellLessonProgress) {
                    text = resources.getString(R.string.one_hundred_percent)
                }
                with(lpiCellLessonProgress) {
                    setIndicatorColor(color)
                    progress = 100
                }
            }
        }
    }

    inner class WaitingViewHolder(private val binding: CellLessonBinding) :
        BaseLessonViewHolder(binding) {

        override fun onBind(item: LessonModel) {
            super.onBind(item)
            val color = ContextCompat.getColor(itemView.context, R.color.lesson_status_waiting)

            binding.apply {
                with(tvCellLessonStatus) {
                    text = item.status?.value
                    setBackgroundColor(color)
                }
                with(tvCellLessonCountDown) {
                    text = resources.getString(
                        R.string.lesson_status_countdown,
                        item.proposalDueTime
                    )
                }
                with(tvCellLessonProgress) {
                    text = resources.getString(
                        R.string.lesson_status_partial,
                        item.soldTicketsNumber,
                        item.successCriteriaNumber
                    )
                }
                with(lpiCellLessonProgress) {
                    setIndicatorColor(color)
                    progress = if (item.successCriteriaNumber == 0 ||
                        item.successCriteriaNumber == null
                    ) {
                        0
                    } else {
                        ((item.soldTicketsNumber?.times(100) ?: 0) / item.successCriteriaNumber)
                    }
                }
            }
        }
    }

    /*
        Extract different types of ViewHolder display logic.
        You should list all the common logic here before adding a new one.
        1. Display lesson title logic
        2. Display lesson image logic
     */
    open inner class BaseLessonViewHolder(private val binding: CellLessonBinding) : RecyclerView
    .ViewHolder(binding.root) {
        open fun onBind(item: LessonModel) {
            binding.apply {
                with(tvCellLessonTitle) {
                    text = item.title
                }
                with(sivCellLessonImage) {
                    Glide.with(this).load(item.imageUrl)
                        .apply(requestOption)
                        .into(this)
                }
            }
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<LessonModel>() {
        override fun areItemsTheSame(oldItem: LessonModel, newItem: LessonModel): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: LessonModel, newItem: LessonModel): Boolean {
            return oldItem == newItem
        }
    }

    companion object {
        private const val VIEW_TYPE_LESSON_SUCCESS = 0x1
        private const val VIEW_TYPE_LESSON_WAITING = 0x2
    }
}