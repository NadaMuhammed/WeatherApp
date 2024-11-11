package com.example.weatherapp.data.repository

import com.example.weatherapp.data.api.CurrentWeatherApi
import com.example.weatherapp.data.model.CurrentWeatherResponse
import com.example.weatherapp.data.model.WeeklyForecastResponse
import com.example.weatherapp.domain.repository.WeatherRepository
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(private val api: CurrentWeatherApi) :
    WeatherRepository {

    override suspend fun getCurrentWeather(country: String): CurrentWeatherResponse {
        return api.getCurrentWeather(country)
    }

    override suspend fun getForecast(
        country: String,
        days: Int?
    ): WeeklyForecastResponse {
        return api.getWeeklyAndDailyWeather(country, days)
    }
}