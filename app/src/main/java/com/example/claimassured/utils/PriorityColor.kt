package com.example.claimassured.utils

import android.content.Context
import androidx.core.content.ContextCompat

enum class PriorityColor(private val colorResId: Int) {
    HIGH(android.R.color.holo_red_dark),
    MEDIUM(android.R.color.holo_orange_dark),
    LOW(android.R.color.holo_green_dark);

    fun toColor(context: Context): Int {
        return ContextCompat.getColor(context, colorResId)
    }
}