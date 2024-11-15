package com.example.weatherapp.domain.mappers

import com.example.utils.TimeFormatter
import com.example.weatherapp.data.model.CurrentWeather
import com.example.weatherapp.data.model.ForecastDay
import com.example.weatherapp.data.model.HourlyWeather
import com.example.weatherapp.data.model.Location
import com.example.weatherapp.data.model.WeeklyForecastResponse
import com.example.weatherapp.domain.entities.CurrentWeatherDTO
import com.example.weatherapp.domain.entities.DailyWeatherDTO
import com.example.weatherapp.domain.entities.ForecastDTO
import com.example.weatherapp.domain.entities.HourlyWeatherDTO
import com.example.weatherapp.domain.enums.ConditionEnum
import com.example.weatherapp.domain.enums.DayOrNightEnum
import com.example.weatherapp.domain.enums.WindDirectionsEnum
import javax.inject.Inject

class ForecastMapper @Inject constructor(private val timeFormatter: TimeFormatter) {
    fun map(weeklyForecastResponse: WeeklyForecastResponse): ForecastDTO {
        return ForecastDTO(
            currentForecast = mapCurrentWeather(weeklyForecastResponse.current, weeklyForecastResponse.location),
            dailyWeatherList = mapDailyForecast(weeklyForecastResponse.forecast.forecastDay),
            hourlyWeatherList = mapHourlyForecast(weeklyForecastResponse.forecast.forecastDay?.get(0)?.hour)
        )
    }

    private fun mapCurrentWeather(
        currentWeather: CurrentWeather?,
        location: Location?
    ): CurrentWeatherDTO {
        return CurrentWeatherDTO(
            name = location?.name,
            region = location?.region,
            country = location?.country,
            temperature = currentWeather?.temperatureInCelsius,
            isDayOrNight = DayOrNightEnum.fromIsDay(currentWeather?.isDay),
            conditionText = currentWeather?.condition?.text,
            windDirection = WindDirectionsEnum.fromWindDirection(
                currentWeather?.windDirection ?: ""
            ).name,
            humidity = currentWeather?.humidity
        )
    }

    private fun mapDailyForecast(forecastDay: List<ForecastDay>?): List<DailyWeatherDTO> {
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


    private fun mapHourlyForecast(hourlyForecast: List<HourlyWeather>?): List<HourlyWeatherDTO> {
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