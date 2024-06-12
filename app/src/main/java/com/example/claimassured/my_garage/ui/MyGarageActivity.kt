package com.example.claimassured.my_garage.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.claimassured.R
import com.example.claimassured.databinding.ActivityMyGarageBinding
import com.example.claimassured.ext.setupFullscreenView

class MyGarageActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMyGarageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyGarageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupFullscreenView()
        setupBottomNavigation()
    }

    private fun setupBottomNavigation() {
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        binding.bottomNavigation.setupWithNavController(navController)
    }
}