package com.example.lista3_1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lista3_1.databinding.FragmentGradesBinding

class Grades : Fragment() {

    private lateinit var binding: FragmentGradesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGradesBinding.inflate(inflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView: RecyclerView = binding.recyclerViewGrades

        val gradeListItems = listOf(
            GradeListItem("Matematyka", 2, 4.0f),
            GradeListItem("PUM", 2, 5.0f),
            GradeListItem("Fizyka", 2, 4.5f),
        )

        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = GradesAdapter(gradeListItems)
    }
}