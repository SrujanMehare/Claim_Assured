package com.example.claimassured.my_garage.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.claimassured.R
import com.example.claimassured.databinding.ActivityMyGarageBinding

class MyGarageActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMyGarageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyGarageBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        val navHostFragment = supportFragmentManager
//            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
//        val navController = navHostFragment.navController
////
//        NavigationUI.setupWithNavController(binding.bottomNavigationView, navController)
////
//        binding.bottomNavigationView.setupWithNavController(
//            findNavController(R.id.nav_host_fragment)
//        )

        // Find the NavHostFragment and NavController
//        val navHostFragment = supportFragmentManager
//            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
//        val navController = navHostFragment.navController
//
//        // Setup BottomNavigationView with NavController
//        binding.bottomNavigationView.setupWithNavController(navController)

//        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
//        val navController = navHostFragment.navController
//        val navView: BottomNavigationView = findViewById(R.id.bottomNavigationView)
//        navView.setupWithNavController(navController)

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        binding.bottomNavigation.setupWithNavController(navController)
    }
}