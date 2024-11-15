package com.example.weatherapp.domain.entities

import com.example.weatherapp.domain.enums.ConditionEnum

data class DailyWeatherDTO(
    val day: String? = null,
    val maxTemp: Double? = 0.0,
    val minTemp: Double? = 0.0,
    val condition: ConditionEnum? = null
)