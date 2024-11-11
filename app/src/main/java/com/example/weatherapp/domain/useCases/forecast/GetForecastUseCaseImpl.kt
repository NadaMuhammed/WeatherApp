package com.example.weatherapp.domain.useCases.forecast

import com.example.weatherapp.data.model.WeeklyForecastResponse
import com.example.weatherapp.domain.repository.WeatherRepository
import javax.inject.Inject

class GetForecastUseCaseImpl @Inject constructor(private val repository: WeatherRepository): GetForecastUseCase {

    override suspend fun getForecast(country: String, days: Int?): WeeklyForecastResponse {
        return repository.getForecast(country, days)
    }
}