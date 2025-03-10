package com.refactoring_android.math_skill.studentList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.refactoring_android.math_skill.databinding.ItemStudentBinding

class StudentListAdapter :
    ListAdapter<String, StudentListAdapter.ItemStudentViewHolder>(diffCallback) {

    inner class ItemStudentViewHolder(val binding: ItemStudentBinding) : ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ItemStudentViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemStudentBinding.inflate(inflater, parent, false)
        return ItemStudentViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: ItemStudentViewHolder,
        position: Int
    ) {
        with(holder) {
        }
    }

    companion object {
        private val diffCallback = object : DiffUtil.ItemCallback<String>() {
            override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
                return oldItem == newItem
            }
        }
    }
}