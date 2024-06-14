package com.example.claimassured.my_tasks

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.lifecycle.lifecycleScope
import com.example.claimassured.R
import com.example.claimassured.databinding.ActivityMyTasksBinding
import com.example.claimassured.ext.setupBottomNavigation
import com.example.claimassured.ext.setupDrawer
import com.example.claimassured.ext.setupFullscreenView
import com.example.claimassured.ext.setupToolbarForMyTask
import com.example.claimassured.ext.startActivity
import com.example.claimassured.my_garage.ui.MyGarageActivity
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MyTaskActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMyTasksBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyTasksBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupFullscreenView()
        setupActionBar()
        setupBottomNavigation(binding.bottomNavigation, R.id.nav_host_fragment_my_task)
        setupBottomNavigationView()
        setupDrawer(R.layout.dashboard_drawer_layout, R.id.nav_view)
        setupClickListener()
    }

    private fun setupClickListener() {

        binding.apply {

            actionBar.navBtn.setOnClickListener {
                drawerLayout.openDrawer(GravityCompat.START)
            }

            navView.drawerCloseBtn.setOnClickListener {
                drawerLayout.closeDrawer(GravityCompat.START)
            }

            navView.myGarageContainer.setOnClickListener {
                lifecycleScope.launch {
                    startActivity<MyGarageActivity>()
                    delay(250)
                    drawerLayout.closeDrawer(GravityCompat.START)
                }
            }
        }
    }

    private fun setupActionBar() {
        binding.actionBar.root.setupToolbarForMyTask()
    }

    private fun setupBottomNavigationView() {
        binding.bottomNavigation.background = null
        binding.bottomNavigation.menu.getItem(2).isEnabled = false
    }

}