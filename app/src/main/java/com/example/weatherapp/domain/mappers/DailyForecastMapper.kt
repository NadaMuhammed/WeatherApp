package com.example.weatherapp.domain.mappers

import com.example.utils.TimeFormatter
import com.example.weatherapp.data.model.ForecastDay
import com.example.weatherapp.domain.entities.DailyWeatherDTO
import com.example.weatherapp.domain.enums.ConditionEnum
import javax.inject.Inject

class DailyForecastMapper @Inject constructor(private val timeFormatter: TimeFormatter) {

    fun map(forecastDay: List<ForecastDay>?): List<DailyWeatherDTO> {
        val dailyWeatherList: MutableList<DailyWeatherDTO> = mutableListOf()

        forecastDay?.let {
            for (day in forecastDay) {
                dailyWeatherList.add(
                    DailyWeatherDTO(
                        day = timeFormatter.formatDateToDay(day.date ?: ""),
                        maxTemp = day.day?.maxTempInCelsius,
                        minTemp = day.day?.minTempInCelsius,
                        condition = ConditionEnum.fromCondition(
                            null,
                            day.day?.condition?.text?.toLowerCase()
                        )
                    )
                )
            }
        }
        return dailyWeatherList
    }
}