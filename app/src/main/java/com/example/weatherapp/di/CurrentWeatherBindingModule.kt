package com.example.weatherapp.di

import com.example.weatherapp.data.repository.CurrentWeatherRepositoryImpl
import com.example.weatherapp.domain.repository.CurrentWeatherRepository
import com.example.weatherapp.domain.useCases.GetCurrentWeatherUseCase
import com.example.weatherapp.domain.useCases.GetCurrentWeatherUseCaseImpl
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