package com.example.weatherapp.domain.entities

data class ForecastDTO (
    val currentForecast: CurrentWeatherDTO? = CurrentWeatherDTO(),
    val dailyWeatherList: List<DailyWeatherDTO>? = emptyList(),
    val hourlyWeatherList: List<HourlyWeatherDTO>? = emptyList()
)