package com.example.weatherapp.features.currentWeather.di

import com.example.weatherapp.features.currentWeather.data.api.CurrentWeatherApi
import com.example.weatherapp.features.currentWeather.domain.mappers.CurrentWeatherMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import retrofit2.Retrofit

@InstallIn(ViewModelComponent::class)
@Module
object CurrentWeatherProvidingModule {

    @Provides
    fun provideCurrentWeatherServices(retrofit: Retrofit): CurrentWeatherApi {
        return retrofit.create(CurrentWeatherApi::class.java)
    }

    @Provides
    fun provideMapper(): CurrentWeatherMapper = CurrentWeatherMapper()
}