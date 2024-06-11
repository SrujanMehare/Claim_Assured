package com.example.claimassured.ext

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast

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