package com.example.weatherapp.domain.useCases.forecast

import com.example.weatherapp.domain.entities.ForecastDTO
import com.example.weatherapp.domain.mappers.ForecastMapper
import com.example.weatherapp.domain.repository.WeatherRepository
import javax.inject.Inject

class GetForecastUseCaseImpl @Inject constructor(
    private val repository: WeatherRepository,
    private val mapper: ForecastMapper
) : GetForecastUseCase {

    override suspend fun invoke(country: String, days: Int?): ForecastDTO {
        repository.getForecast(country, days).let {
            return mapper.map(it)
        }
    }
}