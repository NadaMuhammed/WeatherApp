package com.example.weatherapp.data.repository

import com.example.weatherapp.data.api.CurrentWeatherApi
import com.example.weatherapp.data.model.CurrentWeatherResponse
import com.example.weatherapp.domain.repository.CurrentWeatherRepository
import javax.inject.Inject

class CurrentWeatherRepositoryImpl @Inject constructor(private val api: CurrentWeatherApi) :
    CurrentWeatherRepository {

    override suspend fun getCurrentWeather(country: String): CurrentWeatherResponse {
        return api.getCurrentWeather(country)
    }
}