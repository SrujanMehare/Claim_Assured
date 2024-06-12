package com.example.claimassured.my_garage.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.claimassured.R
import com.example.claimassured.databinding.FragmentAssignedBinding

class AssignedFragment : Fragment() {

    private lateinit var binding: FragmentAssignedBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAssignedBinding.inflate(layoutInflater)
        return binding.root
    }
}