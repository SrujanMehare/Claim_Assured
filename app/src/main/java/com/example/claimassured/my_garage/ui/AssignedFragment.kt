package com.example.claimassured.my_garage.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.claimassured.databinding.FragmentAssignedBinding

class AssignedFragment : Fragment() {

    private lateinit var binding: FragmentAssignedBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentAssignedBinding.inflate(layoutInflater)
        initializeUI()
        return binding.root
    }

    private fun initializeUI() {

    }

}