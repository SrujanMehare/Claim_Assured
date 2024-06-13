package com.example.claimassured.my_garage.model

import android.graphics.drawable.GradientDrawable
import android.view.View
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.example.claimassured.R
import com.example.claimassured.ext.gone
import com.example.claimassured.swipe_button.OnActiveListener
import com.example.claimassured.swipe_button.SwipeButton
import com.example.claimassured.utils.PriorityColor

@BindingAdapter("isWorkerRowVisible")
fun isWorkerRowVisible(view: View, isVisible: Boolean) {
    view.visibility = if (isVisible) View.VISIBLE else View.GONE
}

@BindingAdapter("isLocationRowVisible")
fun isLocationRowVisible(view: View, isVisible: Boolean) {
    view.visibility = if (isVisible) View.VISIBLE else View.GONE
}

@BindingAdapter("canSlideToAssign")
fun canSlideToAssign(view: View, isVisible: Boolean) {
    view.visibility = if (isVisible) View.VISIBLE else View.GONE
}

@BindingAdapter("priorityColor")
fun setPriorityColor(view: View, priority: PriorityColor) {
    // Load the shape drawable
    val shapeDrawable =
        ContextCompat.getDrawable(view.context, R.drawable.card_indicator) as GradientDrawable

    // Mutate and set the color dynamically
    shapeDrawable.mutate()
    shapeDrawable.setColor(priority.toColor(view.context))

    // Set the mutated drawable as the background
    view.background = shapeDrawable
}

@BindingAdapter("onActiveListener")
fun setOnActiveListener(swipeButton: SwipeButton, listener: OnActiveListener?) {
    listener?.let {
        swipeButton.setOnActiveListener(it)
    }
}

@BindingAdapter("isBtnSliderVisible")
fun isBtnSliderVisible(view: View, isVisible: Boolean) {
    view.visibility = if (isVisible) View.VISIBLE else View.GONE
}

@BindingAdapter("onActiveListener")
fun setOnActiveListener(swipeButton: SwipeButton, isVisible: Boolean) {
    if (isVisible) {
        swipeButton.setOnActiveListener(object : OnActiveListener {
            override fun onActive() {
                swipeButton.gone()
            }
        })
    }
}