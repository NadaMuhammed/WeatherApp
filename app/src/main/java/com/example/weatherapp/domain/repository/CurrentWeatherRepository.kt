package com.example.weatherapp.domain.repository

import com.example.weatherapp.data.model.CurrentWeatherResponse

fun interface CurrentWeatherRepository {

    suspend fun getCurrentWeather(country: String): CurrentWeatherResponse
}