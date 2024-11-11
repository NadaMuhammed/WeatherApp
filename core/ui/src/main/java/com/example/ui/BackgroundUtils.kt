package com.example.ui

import android.graphics.drawable.TransitionDrawable
import android.view.View
import androidx.core.content.ContextCompat

object BackgroundUtils {

    fun fadeInBackgroundImage(image: View, newImageRes: Int) {
        val transparentDrawable = ContextCompat.getDrawable(image.context, android.R.color.transparent)
        val transitionDrawable = TransitionDrawable(arrayOf(transparentDrawable, ContextCompat.getDrawable(image.context, newImageRes)))
        image.background = transitionDrawable
        transitionDrawable.startTransition(200)
    }
}