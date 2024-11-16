package com.example.weatherapp.di

import com.example.utils.TimeFormatter
import com.example.weatherapp.data.api.CurrentWeatherApi
import com.example.weatherapp.domain.mappers.CurrentWeatherMapper
import com.example.weatherapp.domain.mappers.DailyForecastMapper
import com.example.weatherapp.domain.mappers.ForecastMapper
import com.example.weatherapp.domain.mappers.HourlyForecastMapper
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
    fun provideCurrentWeatherMapper(): CurrentWeatherMapper = CurrentWeatherMapper()

    @Provides
    fun provideDailyForecastMapper(timeFormatter: TimeFormatter): DailyForecastMapper =
        DailyForecastMapper(timeFormatter)

    @Provides
    fun provideHourlyForecastMapper(timeFormatter: TimeFormatter): HourlyForecastMapper =
        HourlyForecastMapper(timeFormatter)

    @Provides
    fun provideForecastMapper(
        currentWeatherMapper: CurrentWeatherMapper,
        dailyForecastMapper: DailyForecastMapper,
        hourlyForecastMapper: HourlyForecastMapper
    ): ForecastMapper =
        ForecastMapper(
            currentWeatherMapper,
            dailyForecastMapper,
            hourlyForecastMapper
        )
}