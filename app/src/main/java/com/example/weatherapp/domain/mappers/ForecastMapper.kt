package com.example.weatherapp.domain.mappers

import com.example.weatherapp.data.model.WeeklyForecastResponse
import com.example.weatherapp.domain.entities.ForecastDTO
import javax.inject.Inject

class ForecastMapper @Inject constructor(
    private val currentWeatherMapper: CurrentWeatherMapper,
    private val dailyForecastMapper: DailyForecastMapper,
    private val hourlyForecastMapper: HourlyForecastMapper
) {
    fun map(weeklyForecastResponse: WeeklyForecastResponse): ForecastDTO {
        return ForecastDTO(
            currentForecast = currentWeatherMapper.map(
                weeklyForecastResponse.current,
                weeklyForecastResponse.location
            ),
            dailyWeatherList = dailyForecastMapper.map(weeklyForecastResponse.forecast.forecastDay),
            hourlyWeatherList = hourlyForecastMapper.map(
                weeklyForecastResponse.forecast.forecastDay?.get(
                    0
                )?.hour
            )
        )
    }
}