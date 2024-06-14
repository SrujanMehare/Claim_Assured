package com.example.claimassured.my_garage.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.claimassured.R
import com.example.claimassured.databinding.ActivityMyGarageBinding
import com.example.claimassured.ext.setupBottomNavigation
import com.example.claimassured.ext.setupFullscreenView
import com.example.claimassured.ext.setupToolbarForMyGarage

class MyGarageActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMyGarageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyGarageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupFullscreenView()
        setupActionBar()
        setupBottomNavigation(binding.bottomNavigation, R.id.nav_host_fragment_garage)
        setupClickListeners()
    }

    private fun setupClickListeners() {
        binding.actionBar.navBtn.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
    }

    private fun setupActionBar() {
        binding.actionBar.root.setupToolbarForMyGarage()
    }

}