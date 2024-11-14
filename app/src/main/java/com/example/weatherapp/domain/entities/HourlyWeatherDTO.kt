package com.example.weatherapp.domain.entities

import com.example.weatherapp.domain.enums.ConditionEnum

data class HourlyWeatherDTO (
    val hour: String? = null,
    val temperature: Double? = 0.0,
    val condition: ConditionEnum? = null
)