package com.example.weatherapp.di

import com.example.weatherapp.data.api.CurrentWeatherApi
import com.example.weatherapp.domain.mappers.CurrentWeatherMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import retrofit2.Retrofit

@InstallIn(ViewModelComponent::class)
@Module
object WeatherProvidingModule {

    @Provides
    fun provideCurrentWeatherServices(retrofit: Retrofit): CurrentWeatherApi {
        return retrofit.create(CurrentWeatherApi::class.java)
    }

    @Provides
    fun provideMapper(): CurrentWeatherMapper = CurrentWeatherMapper()
}