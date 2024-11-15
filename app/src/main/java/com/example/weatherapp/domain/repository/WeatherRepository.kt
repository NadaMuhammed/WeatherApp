package com.example.weatherapp.domain.repository

import com.example.weatherapp.data.model.WeeklyForecastResponse

fun interface WeatherRepository {

    suspend fun getForecast(country: String, days: Int?): WeeklyForecastResponse
}