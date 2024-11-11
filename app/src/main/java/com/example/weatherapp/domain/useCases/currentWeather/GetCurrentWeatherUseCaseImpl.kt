package com.example.weatherapp.domain.useCases.currentWeather

import com.example.weatherapp.domain.entities.CurrentWeatherDTO
import com.example.weatherapp.domain.mappers.CurrentWeatherMapper
import com.example.weatherapp.domain.repository.WeatherRepository
import javax.inject.Inject

class GetCurrentWeatherUseCaseImpl @Inject constructor(
    private val repository: WeatherRepository,
    private val mapper: CurrentWeatherMapper
) :
    GetCurrentWeatherUseCase {

    override suspend fun invoke(country: String): CurrentWeatherDTO {
        return repository.getCurrentWeather(country).let {
            mapper.map(it)
        }
    }
}