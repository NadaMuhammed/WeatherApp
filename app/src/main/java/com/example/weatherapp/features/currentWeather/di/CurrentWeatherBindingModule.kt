package com.example.weatherapp.features.currentWeather.di

import com.example.weatherapp.features.currentWeather.domain.useCases.GetCurrentWeatherUseCase
import com.example.weatherapp.features.currentWeather.domain.useCases.GetCurrentWeatherUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@InstallIn(ViewModelComponent::class)
@Module
fun interface CurrentWeatherBindingModule {

    @Binds
    fun bindCurrentWeatherUseCase(getCurrentWeatherUseCaseImpl: GetCurrentWeatherUseCaseImpl): GetCurrentWeatherUseCase
}