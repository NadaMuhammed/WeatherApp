package com.example.weatherapp.domain.entities

data class ForecastDTO (
    val dailyWeatherDTO: List<DailyWeatherDTO>? = emptyList(),
    val hourlyWeatherDTO: List<HourlyWeatherDTO>? = emptyList()
)