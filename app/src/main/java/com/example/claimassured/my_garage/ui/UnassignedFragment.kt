package com.example.claimassured.my_garage.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.claimassured.R
import com.example.claimassured.databinding.FragmentUnassignedBinding
import com.example.claimassured.ext.gone
import com.example.claimassured.ext.setImageDrawableRes
import com.example.claimassured.ext.visible
import com.example.claimassured.my_garage.model.MyGarageModel
import com.example.claimassured.my_garage.ui.adapter.GarageAdapter
import com.example.claimassured.my_garage.ui.test.TestClass.Companion.generateRandomGarageModels

class UnassignedFragment : Fragment() {

    private lateinit var binding: FragmentUnassignedBinding
    private lateinit var myGarageAdapter: GarageAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
       binding = FragmentUnassignedBinding.inflate(layoutInflater)
        setupViews()
        return binding.root
    }

    private fun setupViews() {
        setupToolbar()

        val garageList = createDummyMyGarageList()

        myGarageAdapter = GarageAdapter(garageList)

        binding.rvMyGarage.apply {
            adapter = myGarageAdapter
            layoutManager =
                LinearLayoutManager(requireContext())
        }
    }

    private fun createDummyMyGarageList(): List<MyGarageModel> {
        return generateRandomGarageModels(10)
    }

    private fun setupToolbar() {
        binding.actionBar.navBtn.setImageDrawableRes(R.drawable.icon_back)
        binding.actionBar.headingTxt.text = getString(R.string.my_garage)
        binding.actionBar.btnSort.gone()
        binding.actionBar.serviceCenterName.visible()
    }

}