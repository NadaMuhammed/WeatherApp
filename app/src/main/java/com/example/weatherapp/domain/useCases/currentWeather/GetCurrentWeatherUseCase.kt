package com.example.weatherapp.domain.useCases.currentWeather

import com.example.weatherapp.domain.entities.CurrentWeatherDTO

fun interface GetCurrentWeatherUseCase {

    suspend fun invoke(country: String): CurrentWeatherDTO
}