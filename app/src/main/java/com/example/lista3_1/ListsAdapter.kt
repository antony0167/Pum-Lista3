package com.example.lista3_1

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lista3_1.databinding.ItemListBinding

class ListsAdapter(
    private val taskList: List<TaskListItem>,
    private val onItemClick: (TaskListItem) -> Unit
) : RecyclerView.Adapter<ListsAdapter.TaskListViewHolder>() {

    inner class TaskListViewHolder(
        private val binding: ItemListBinding,
        private val onItemClick: (TaskListItem) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        val subjectText: TextView = binding.subjectText
        val listNameText: TextView = binding.listNameText
        val taskCountText: TextView = binding.taskCountText
        val gradeText: TextView = binding.gradeText

        fun bind(task: TaskListItem) {
            subjectText.text = task.subject
            listNameText.text = task.listName
            taskCountText.text = "Liczba zadań: ${task.taskCount}"
            gradeText.text = "Ocena: ${task.grade}"

            itemView.setOnClickListener {
                onItemClick(task)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskListViewHolder {
        return TaskListViewHolder(
            ItemListBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            ),
            onItemClick
        )
    }

    override fun onBindViewHolder(holder: TaskListViewHolder, position: Int) {
        holder.bind(taskList[position])
    }

    override fun getItemCount(): Int = taskList.size
}
