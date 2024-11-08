package com.example.weatherapp.features.currentWeather.data.repository

import com.example.weatherapp.features.currentWeather.data.api.CurrentWeatherApi
import com.example.weatherapp.features.currentWeather.data.model.CurrentWeatherResponse
import com.example.weatherapp.features.currentWeather.domain.repository.CurrentWeatherRepository
import javax.inject.Inject

class CurrentWeatherRepositoryImpl @Inject constructor(private val api: CurrentWeatherApi) :
    CurrentWeatherRepository {

    override suspend fun getCurrentWeather(country: String): CurrentWeatherResponse {
        return api.getCurrentWeather(country)
    }
}