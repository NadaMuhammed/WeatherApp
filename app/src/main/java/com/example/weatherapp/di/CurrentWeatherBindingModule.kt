package com.example.weatherapp.features.currentWeather.di

import com.example.weatherapp.features.currentWeather.data.repository.CurrentWeatherRepositoryImpl
import com.example.weatherapp.features.currentWeather.domain.repository.CurrentWeatherRepository
import com.example.weatherapp.features.currentWeather.domain.useCases.GetCurrentWeatherUseCase
import com.example.weatherapp.features.currentWeather.domain.useCases.GetCurrentWeatherUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@InstallIn(ViewModelComponent::class)
@Module
interface CurrentWeatherBindingModule {

    @Binds
    fun bindCurrentWeatherRepository(currentWeatherRepositoryImpl: CurrentWeatherRepositoryImpl): CurrentWeatherRepository

    @Binds
    fun bindCurrentWeatherUseCase(getCurrentWeatherUseCaseImpl: GetCurrentWeatherUseCaseImpl): GetCurrentWeatherUseCase
}