package com.example.ui

import android.graphics.drawable.TransitionDrawable
import android.view.View
import androidx.core.content.ContextCompat

object BackgroundUtils {

    fun View.fadeInBackgroundImage(newImageRes: Int) {
        val transparentDrawable = ContextCompat.getDrawable(context, android.R.color.transparent)
        val transitionDrawable = TransitionDrawable(arrayOf(transparentDrawable, ContextCompat.getDrawable(context, newImageRes)))
        background = transitionDrawable
        transitionDrawable.startTransition(200)
    }
}