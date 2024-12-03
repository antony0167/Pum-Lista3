package com.example.lista3_1

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lista3_1.databinding.ItemGradeBinding

class GradesAdapter(
    private val gradeList: List<GradeListItem>
) : RecyclerView.Adapter<GradesAdapter.GradeListViewHolder>() {

    class GradeListViewHolder(private val binding: ItemGradeBinding) : RecyclerView.ViewHolder(binding.root) {
        val subjectText: TextView = binding.subjectText
        val gradeText: TextView = binding.gradeText
        val listCountText: TextView = binding.listCountText
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GradeListViewHolder {
        return GradeListViewHolder(
            ItemGradeBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: GradeListViewHolder, position: Int) {
        val item = gradeList[position]
        holder.subjectText.text = item.subject
        holder.gradeText.text = "Średnia: ${item.grade}"
        holder.listCountText.text = "Liczba list: ${item.listCount}"
    }

    override fun getItemCount(): Int = gradeList.size
}