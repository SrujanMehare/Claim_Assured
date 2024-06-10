package com.example.claimassured

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN

//        window.decorView.apply {
//            // Hide the status bar.
//            WindowInsetsControllerCompat(window, this).hide(WindowInsetsCompat.Type.statusBars())
//        }
//
//        // Hide the status bar initially
//        hideStatusBar()
//
//        // Set up a system UI visibility change listener
//        window.decorView.setOnSystemUiVisibilityChangeListener { visibility ->
//            if (visibility and View.SYSTEM_UI_FLAG_FULLSCREEN == 0) {
//                // Status bar is visible, hide it again
//                hideStatusBar()
//            }
//        }
    }

    //** Hide status bar **//
    private fun hideStatusBar() {
        window.decorView.apply {
            systemUiVisibility = (
                    View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                            or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    )
        }
    }
}