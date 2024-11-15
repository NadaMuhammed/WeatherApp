package com.example.weatherapp.domain.useCases.forecast

import com.example.weatherapp.domain.entities.ForecastDTO

fun interface GetForecastUseCase {
    suspend fun invoke(country: String, days: Int?): ForecastDTO
}