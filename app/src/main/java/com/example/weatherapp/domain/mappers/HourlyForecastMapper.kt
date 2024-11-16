package com.example.weatherapp.domain.mappers

import com.example.utils.TimeFormatter
import com.example.weatherapp.data.model.HourlyWeather
import com.example.weatherapp.domain.entities.HourlyWeatherDTO
import com.example.weatherapp.domain.enums.ConditionEnum
import com.example.weatherapp.domain.enums.DayOrNightEnum
import javax.inject.Inject

class HourlyForecastMapper @Inject constructor(private val timeFormatter: TimeFormatter) {

    fun map(hourlyForecast: List<HourlyWeather>?): List<HourlyWeatherDTO> {
        val hourlyWeatherList: MutableList<HourlyWeatherDTO> = mutableListOf()

        hourlyForecast?.let {
            for (hour in hourlyForecast) {
                hourlyWeatherList.add(
                    HourlyWeatherDTO(
                        hour = timeFormatter.formatHour(hour.time ?: ""),
                        temperature = hour.temperatureInCelsius,
                        condition = ConditionEnum.fromCondition(
                            DayOrNightEnum.fromIsDay(hour.isDay),
                            hour.condition.text?.toLowerCase()
                        )
                    )
                )
            }
        }

        return hourlyWeatherList
    }
}