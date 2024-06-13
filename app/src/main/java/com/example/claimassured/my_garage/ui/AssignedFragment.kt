package com.example.claimassured.my_garage.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.claimassured.databinding.FragmentAssignedBinding
import com.example.claimassured.ext.setupToolbarForGarage
import com.example.claimassured.my_garage.model.MyGarageModel
import com.example.claimassured.my_garage.ui.adapter.GarageAdapter
import com.example.claimassured.my_garage.ui.test.TestClass.Companion.generateAssignedTaskList

class AssignedFragment : Fragment() {

    private lateinit var binding: FragmentAssignedBinding
    private lateinit var myGarageAdapter: GarageAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAssignedBinding.inflate(layoutInflater)
        setupViews()
        return binding.root
    }

    private fun setupViews() {
        setupToolbar()
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
        return generateAssignedTaskList(10)
    }

    private fun setupToolbar() {
        binding.actionBar.root.setupToolbarForGarage()
    }
}