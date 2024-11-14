package com.example.weatherapp.domain.useCases.forecast

import com.example.weatherapp.data.model.WeeklyForecastResponse

fun interface GetForecastUseCase {
    suspend fun invoke(country: String, days: Int?): WeeklyForecastResponse
}