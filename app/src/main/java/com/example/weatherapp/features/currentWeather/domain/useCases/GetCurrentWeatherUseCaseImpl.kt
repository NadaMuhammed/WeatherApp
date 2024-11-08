package com.example.weatherapp.features.currentWeather.domain.useCases

import com.example.weatherapp.features.currentWeather.domain.entities.CurrentWeatherDTO
import com.example.weatherapp.features.currentWeather.domain.mappers.CurrentWeatherMapper
import com.example.weatherapp.features.currentWeather.domain.repository.CurrentWeatherRepository
import javax.inject.Inject

class GetCurrentWeatherUseCaseImpl @Inject constructor(
    private val repository: CurrentWeatherRepository,
    private val mapper: CurrentWeatherMapper
) :
    GetCurrentWeatherUseCase {

    override suspend fun invoke(country: String): CurrentWeatherDTO? {
        return repository.getCurrentWeather(country).getOrNull()?.let {
            mapper.map(it)
        }
    }
}