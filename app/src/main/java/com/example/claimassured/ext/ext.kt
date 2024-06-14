package com.example.claimassured.ext

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.DrawableRes
import androidx.annotation.LayoutRes
import androidx.appcompat.widget.Toolbar
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.claimassured.R
import com.google.android.material.bottomnavigation.BottomNavigationView

// Extension function to set the view's visibility to VISIBLE
fun View.visible() {
    this.visibility = View.VISIBLE
}

// Extension function to set the view's visibility to INVISIBLE
fun View.invisible() {
    this.visibility = View.INVISIBLE
}

// Extension function to set the view's visibility to GONE
fun View.gone() {
    this.visibility = View.GONE
}

fun Context.showToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

// Extension function to show a long Toast message
fun Context.showLongToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}

// Extension function to start a new activity
inline fun <reified T : Any> Context.startActivity(
    extras: Bundle? = null
) {
    val intent = Intent(this, T::class.java)
    extras?.let {
        intent.putExtras(it)
    }
    startActivity(intent)
}

inline fun <reified T : Any> Fragment.startActivity(
    extras: Bundle? = null
) {
    val intent = Intent(requireContext(), T::class.java)
    extras?.let {
        intent.putExtras(it)
    }
    startActivity(intent)
}

fun ImageView.setImageDrawableRes(@DrawableRes resId: Int) {
    setImageDrawable(ResourcesCompat.getDrawable(resources, resId, context.theme))
}


fun Toolbar.setNavIcon(@DrawableRes resId: Int) {
    navigationIcon = ResourcesCompat.getDrawable(resources, resId, context.theme)
}

@Suppress("DEPRECATION")
// Make the status bar icons white and layout fullscreen
fun Activity.setupFullscreenView() {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {

//        WindowCompat.getInsetsController(window, window.decorView).let {
//            it.systemBarsBehavior =
//                androidx.core.view.WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
//            it.hide(androidx.core.view.WindowInsetsCompat.Type.systemBars())
//        }

        window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN)

//        WindowCompat.setDecorFitsSystemWindows(window, false)
    } else {
        window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN)
    }
}

fun ViewGroup.setupToolbarForMyGarage(
) {
    val navBtn = findViewById<ImageView>(R.id.nav_btn)
    val headingTxt = findViewById<TextView>(R.id.heading_txt)
    val btnSort = findViewById<View>(R.id.btn_sort)
    val serviceCenterName = findViewById<View>(R.id.service_center_name)

    navBtn?.setImageDrawableRes(R.drawable.icon_back)
    headingTxt?.text = context.getString(R.string.my_garage)
    btnSort?.gone()
    serviceCenterName?.visible()
}

fun ViewGroup.setupToolbarForMyTask(
) {
    val navBtn = findViewById<ImageView>(R.id.nav_btn)
    val headingTxt = findViewById<TextView>(R.id.heading_txt)
    val btnSort = findViewById<View>(R.id.btn_sort)
    val serviceCenterName = findViewById<View>(R.id.service_center_name)

    navBtn?.setImageDrawableRes(R.drawable.icon_burger_menu)
    headingTxt?.text = context.getString(R.string.my_tasks)
    btnSort?.visible()
    serviceCenterName?.invisible()
}

fun FragmentActivity.setupBottomNavigation(bottomNavigationView: BottomNavigationView, navHostFragmentId: Int) {
    val navHostFragment =
        supportFragmentManager.findFragmentById(navHostFragmentId) as NavHostFragment
    val navController = navHostFragment.navController
    bottomNavigationView.setupWithNavController(navController)
}

fun Activity.setupDrawer(
    @LayoutRes customNavigationLayoutId: Int,
    navigationContainerId: Int
) {
    val customNavigationContainer = findViewById<ConstraintLayout>(navigationContainerId)
    val customNavigationView = layoutInflater.inflate(
        customNavigationLayoutId,
        customNavigationContainer,
        false
    )
    customNavigationContainer.addView(customNavigationView)
}