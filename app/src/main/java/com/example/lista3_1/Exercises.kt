package com.example.lista3_1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lista3_1.databinding.FragmentExercisesBinding

class Exercises : Fragment() {

    private lateinit var binding: FragmentExercisesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentExercisesBinding.inflate(inflater)

        val subjectName = arguments?.getString("subjectName") ?: "Brak danych"
        val listName = arguments?.getString("listName") ?: "Brak danych"
        val taskCount = arguments?.getInt("taskCount") ?: 0
        val grade = arguments?.getFloat("grade") ?: 0.0f


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView: RecyclerView = binding.recyclerViewExercises

        val exerciseListItems = listOf(
            ExerciseListItem("Zadanie 1", "Kupa", 1.0f)
        )

        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = ExerciseAdapter(exerciseListItems)
    }
}