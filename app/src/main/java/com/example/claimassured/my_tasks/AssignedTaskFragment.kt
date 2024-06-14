package com.example.claimassured.my_tasks

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.claimassured.databinding.FragmentAssignedTaskBinding
import com.example.claimassured.my_garage.model.MyGarageModel
import com.example.claimassured.my_garage.ui.adapter.GarageAdapter
import com.example.claimassured.my_garage.ui.test.TestClass.Companion.generateAssignedTaskList

class AssignedTaskFragment : Fragment() {

    private lateinit var binding: FragmentAssignedTaskBinding
    private lateinit var myGarageAdapter: GarageAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAssignedTaskBinding.inflate(layoutInflater)
        setupUI()
        return binding.root
    }

    private fun setupUI() {
        setupAdapter()
        setupClickListeners()
    }

    private fun setupClickListeners() {

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
        return generateAssignedTaskList(10)
    }
}