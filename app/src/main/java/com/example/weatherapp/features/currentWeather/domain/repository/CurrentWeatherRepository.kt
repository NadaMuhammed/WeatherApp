package com.example.weatherapp.features.currentWeather.domain.repository

import com.example.weatherapp.features.currentWeather.data.model.CurrentWeatherResponse

fun interface CurrentWeatherRepository {

    suspend fun getCurrentWeather(country: String): Result<CurrentWeatherResponse>
}