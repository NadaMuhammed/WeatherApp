package com.example.utils

import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

object TimeFormatter {
    fun formatHour(input: String): String {
        val inputFormat = SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault())
        val outputFormat = SimpleDateFormat("h a", Locale.getDefault())
        val date = inputFormat.parse(input) ?: return ""
        val formattedTime = outputFormat.format(date)
        return formattedTime
    }

    fun formatDateToDay(input: String): String {
        // Define the input date format
        val inputFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        val date = inputFormat.parse(input) ?: return ""

        // Get today's date
        val today = Calendar.getInstance()

        // Get the date from the input string
        val calendar = Calendar.getInstance()
        calendar.time = date

        // Check if the input date is today
        return if (today[Calendar.YEAR] == calendar[Calendar.YEAR] &&
            today[Calendar.DAY_OF_YEAR] == calendar[Calendar.DAY_OF_YEAR]) {
            "Today"
        } else {
            // If not today, return the day of the week
            val dayFormat = SimpleDateFormat("EEEE", Locale.getDefault())
            dayFormat.format(date)
        }
    }

}