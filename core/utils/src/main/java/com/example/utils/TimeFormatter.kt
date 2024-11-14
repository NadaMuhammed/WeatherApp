package com.example.utils

import java.text.SimpleDateFormat
import java.util.Locale

object TimeFormatter {
    fun formatDateTime(input: String): String {
        val inputFormat = SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault())
        val outputFormat = SimpleDateFormat("h a", Locale.getDefault())
        val date = inputFormat.parse(input) ?: return ""
        val formattedTime = outputFormat.format(date)
        return formattedTime
    }
}