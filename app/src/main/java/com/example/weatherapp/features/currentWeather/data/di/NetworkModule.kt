package com.example.weatherapp.features.currentWeather.data.di

import com.example.weatherapp.features.currentWeather.data.api.CurrentWeatherApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@InstallIn(ViewModelComponent::class)
@Module
object NetworkModule {

    @Singleton
    @Provides
    fun provideApi(retrofit: Retrofit): CurrentWeatherApi {
        return retrofit.create(CurrentWeatherApi::class.java)
    }
}