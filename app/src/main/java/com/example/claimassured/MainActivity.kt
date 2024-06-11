package com.example.claimassured

import android.graphics.drawable.GradientDrawable
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.claimassured.databinding.ActivityMainBinding
import com.example.claimassured.databinding.MyTaskCardLayoutBinding
import com.example.claimassured.ext.gone
import com.example.claimassured.ext.showToast
import com.example.claimassured.ext.startActivity
import com.example.claimassured.ext.visible
import com.example.claimassured.my_garage.ui.MyGarageActivity
import com.example.claimassured.swipe_button.OnActiveListener
import com.example.claimassured.utils.PriorityColor

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupFullscreenView()
        setupSliderButton()
        setupCardCallback()
        setupMoreButtonCallback()
        setupBottomNavigationView()
        setupDynamicIndicator(binding.vehicleDetailsTwo.cardIndicator, PriorityColor.HIGH)
        setupDynamicIndicator(binding.vehicleDetailsOne.cardIndicator, PriorityColor.LOW)
    }

    private fun setupDynamicIndicator(view: View, priority: PriorityColor) {

        // Load the shape drawable
        val shapeDrawable =
            ContextCompat.getDrawable(this, R.drawable.card_indicator) as GradientDrawable

        // Mutate and set the color dynamically
        shapeDrawable.mutate()
        shapeDrawable.setColor(priority.toColor(this))

        // Set the mutated drawable as the background
        view.background = shapeDrawable
    }

    // Make the status bar icons white and layout fullscreen
    private fun setupFullscreenView() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
//            window.insetsController?.let {
//                it.hide(WindowInsetsController.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE)
//            }
//            window.setDecorFitsSystemWindows(false)
            @Suppress("DEPRECATION")
            window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN)
        } else {
            @Suppress("DEPRECATION")
            window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN)
        }

        // Adjust the bottom padding of BottomNavigationView to respect system insets
//        ViewCompat.setOnApplyWindowInsetsListener(binding.bottomNavigationView) { view, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            view.updatePadding(bottom = systemBars.bottom)
//            insets
//        }
    }

    // Callback for more button
    private fun setupMoreButtonCallback() {
        binding.vehicleDetailsOne.moreBtn.setOnClickListener {
            // more button clicked
            showToast("More button clicked")
        }

        binding.vehicleDetailsTwo.moreBtn.setOnClickListener {
            // more button clicked
            showToast("More button clicked")
        }
    }

    // Callback for card
    private fun setupCardCallback() {
        binding.vehicleDetailsOne.root.setOnClickListener {
            // card clicked
            showToast("Card clicked")
            startActivity<MyGarageActivity>()
        }

        binding.vehicleDetailsTwo.root.setOnClickListener {
            // card clicked
            showToast("Card clicked")
        }
    }

    // Callback for slider button
    private fun setupSliderButton() {
        binding.vehicleDetailsTwo.apply {

            btnSlider.setOnActiveListener(object : OnActiveListener {
                override fun onActive() {
                    // swiped and task assigned to me
                    taskAssigned(this@apply)
                }
            })
        }

        binding.vehicleDetailsOne.apply {
            btnSlider.setOnActiveListener(object : OnActiveListener {
                override fun onActive() {
                    // swiped and task assigned to me
                    taskAssigned(this@apply)
                }
            })
        }
    }

    // task assigned show worker row
    private fun taskAssigned(view: MyTaskCardLayoutBinding) {
        showToast("Swipe triggered")
        view.apply {
            // swiped and task assigned to me
            btnSlider.gone()

            // show worker row
            workerRow.visible()

            // hide location row
            locationRow.gone()
        }
    }

    private fun setupBottomNavigationView() {
        binding.bottomNavigationView.background = null
        binding.bottomNavigationView.menu.getItem(2).isEnabled = false
    }

}