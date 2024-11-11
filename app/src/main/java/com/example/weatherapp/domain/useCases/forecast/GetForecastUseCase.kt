package com.example.weatherapp.domain.useCases.forecast

import com.example.weatherapp.data.model.WeeklyForecastResponse

fun interface GetForecastUseCase {
    suspend fun getForecast(country: String, days: Int?): WeeklyForecastResponse
}