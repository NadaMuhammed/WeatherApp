package com.example.weatherapp.domain.repository

import com.example.weatherapp.data.model.CurrentWeatherResponse
import com.example.weatherapp.data.model.WeeklyForecastResponse

interface WeatherRepository {

    suspend fun getCurrentWeather(country: String): CurrentWeatherResponse

    suspend fun getForecast(country: String, days: Int?): WeeklyForecastResponse
}