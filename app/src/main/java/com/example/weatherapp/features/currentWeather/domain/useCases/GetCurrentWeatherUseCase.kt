package com.example.weatherapp.features.currentWeather.domain.useCases

import com.example.weatherapp.features.currentWeather.domain.entities.CurrentWeatherDTO

fun interface GetCurrentWeatherUseCase {

    suspend fun invoke(country: String): CurrentWeatherDTO?
}