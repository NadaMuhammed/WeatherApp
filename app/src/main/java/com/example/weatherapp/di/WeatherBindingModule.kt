package com.example.weatherapp.di

import com.example.weatherapp.data.repository.WeatherRepositoryImpl
import com.example.weatherapp.domain.repository.WeatherRepository
import com.example.weatherapp.domain.useCases.currentWeather.GetCurrentWeatherUseCase
import com.example.weatherapp.domain.useCases.currentWeather.GetCurrentWeatherUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@InstallIn(ViewModelComponent::class)
@Module
interface WeatherBindingModule {

    @Binds
    fun bindCurrentWeatherRepository(weatherRepositoryImpl: WeatherRepositoryImpl): WeatherRepository

    @Binds
    fun bindCurrentWeatherUseCase(getCurrentWeatherUseCaseImpl: GetCurrentWeatherUseCaseImpl): GetCurrentWeatherUseCase
}