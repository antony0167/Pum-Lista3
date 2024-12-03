package com.example.lista3_1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lista3_1.databinding.FragmentListsBinding

class Lists : Fragment() {

    private lateinit var binding: FragmentListsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListsBinding.inflate(inflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView: RecyclerView = binding.recyclerViewTasks

        val taskListItems = listOf(
            TaskListItem("Matematyka", "Lista 1", 10, 3.5f),
            TaskListItem("Matematyka", "Lista 2", 10, 4.5f),
            TaskListItem("PUM", "Lista 1", 1, 5.0f),
            TaskListItem("PUM", "Lista 2", 1, 5.0f),
            TaskListItem("Fizyka", "Lista 1", 5, 5.0f),
            TaskListItem("Fizyka", "Lista 2", 3, 4.0f)
        )

        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = ListsAdapter(taskListItems) { taskItem ->
            navigateToExercisesFragment(taskItem)
        }
    }

    private fun navigateToExercisesFragment(taskItem: TaskListItem) {
        val bundle = Bundle().apply {
            putString("subjectName", taskItem.subject)
            putString("listName", taskItem.listName)
            putInt("taskCount", taskItem.taskCount)
            putFloat("grade", taskItem.grade)
        }

        findNavController().navigate(R.id.action_listsFragment_to_exercisesFragment, bundle)
    }
}