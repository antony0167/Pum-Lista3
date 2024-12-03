package com.example.lista3_1

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lista3_1.databinding.ItemExerciseBinding

class ExerciseAdapter (
    private val exerciseList: List<ExerciseListItem>
) : RecyclerView.Adapter<ExerciseAdapter.ExerciseListViewHolder>() {

    class ExerciseListViewHolder(private val binding: ItemExerciseBinding) : RecyclerView.ViewHolder(binding.root) {
        val exerciseTitle: TextView = binding.exerciseTitle
        val exercisePoints: TextView = binding.exercisePoints
        val exerciseDescription: TextView = binding.exerciseDescription
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExerciseListViewHolder {
        return ExerciseListViewHolder(
            ItemExerciseBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ExerciseListViewHolder, position: Int) {
        val item = exerciseList[position]
        holder.exercisePoints.text = "Pkt: ${item.exercisePoints}"
        holder.exerciseTitle.text = "Zadanie ${item.exerciseTitle}"
        holder.exerciseDescription.text = "${item.exerciseDescription}"
    }

    override fun getItemCount(): Int = exerciseList.size

}