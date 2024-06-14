package com.example.claimassured.my_tasks

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.claimassured.databinding.FragmentCompletedTaskBinding
import com.example.claimassured.my_garage.model.MyGarageModel
import com.example.claimassured.my_garage.ui.adapter.GarageAdapter
import com.example.claimassured.my_garage.ui.test.TestClass.Companion.generateCompletedTaskList

class CompletedTaskFragment : Fragment() {

    private lateinit var binding: FragmentCompletedTaskBinding
    private lateinit var myGarageAdapter: GarageAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCompletedTaskBinding.inflate(layoutInflater)
        setupViews()
        return binding.root
    }

    private fun setupViews() {
        setupAdapter()
    }

    private fun setupAdapter() {

        val garageList = createDummyMyGarageList()

        myGarageAdapter = GarageAdapter(garageList)

        binding.rvMyGarage.apply {
            adapter = myGarageAdapter
            layoutManager =
                LinearLayoutManager(requireContext())
        }
    }

    private fun createDummyMyGarageList(): List<MyGarageModel> {
        return generateCompletedTaskList(10)
    }
}