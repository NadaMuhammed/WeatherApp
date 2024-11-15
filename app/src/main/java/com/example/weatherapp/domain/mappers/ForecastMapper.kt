package com.example.weatherapp.domain.mappers

import com.example.utils.TimeFormatter
import com.example.weatherapp.data.model.Forecast
import com.example.weatherapp.domain.entities.DailyWeatherDTO
import com.example.weatherapp.domain.entities.ForecastDTO
import com.example.weatherapp.domain.entities.HourlyWeatherDTO
import com.example.weatherapp.domain.enums.ConditionEnum
import com.example.weatherapp.domain.enums.DayOrNightEnum
import javax.inject.Inject

class ForecastMapper @Inject constructor(private val timeFormatter: TimeFormatter) {
    fun map(forecast: Forecast): ForecastDTO {
        val hourlyForecast = forecast.forecastDay?.get(0)?.hour
        val hourlyWeatherList: MutableList<HourlyWeatherDTO> = mutableListOf()
        val dailyWeatherList: MutableList<DailyWeatherDTO> = mutableListOf()
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

        for (day in forecast.forecastDay ?: emptyList()) {
            dailyWeatherList.add(
                DailyWeatherDTO(
                    day = timeFormatter.formatDateToDay(day.date ?: ""),
                    maxTemp = day.day?.maxTempInCelsius,
                    minTemp = day.day?.minTempInCelsius,
                    condition = ConditionEnum.fromCondition(null, day.day?.condition?.text?.toLowerCase())
                )
            )
        }

        return ForecastDTO(dailyWeatherList = dailyWeatherList, hourlyWeatherList = hourlyWeatherList)
    }
}