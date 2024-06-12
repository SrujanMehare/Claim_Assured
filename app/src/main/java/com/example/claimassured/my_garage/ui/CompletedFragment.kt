package com.example.claimassured.my_garage.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.claimassured.R
import com.example.claimassured.databinding.FragmentCompletedBinding

class CompletedFragment : Fragment() {

    private lateinit var binding: FragmentCompletedBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCompletedBinding.inflate(layoutInflater)
        return binding.root
    }
}