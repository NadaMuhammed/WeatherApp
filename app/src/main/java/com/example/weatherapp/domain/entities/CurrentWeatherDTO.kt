package com.example.weatherapp.features.currentWeather.domain.entities

import com.example.weatherapp.features.currentWeather.domain.enums.DayOrNightEnum

data class CurrentWeatherDTO(
    val name: String? = null,
    val region: String? = null,
    val country: String? = null,
    val temperature: Double? = 0.0,
    val isDayOrNight: DayOrNightEnum,
    val condition: String? = null,
    val windDirection: String? = null,
    val humidity: Int? = 0,
)