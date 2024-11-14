package com.example.weatherapp.domain.entities

import com.example.weatherapp.domain.enums.ConditionEnum

data class DailyWeatherDTO(
    val day: String,
    val maxTemp: Double,
    val minTemp: Double,
    val condition: ConditionEnum
)