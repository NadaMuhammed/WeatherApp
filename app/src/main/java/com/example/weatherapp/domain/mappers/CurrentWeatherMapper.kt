package com.example.weatherapp.domain.mappers

import com.example.weatherapp.data.model.CurrentWeather
import com.example.weatherapp.data.model.Location
import com.example.weatherapp.domain.entities.CurrentWeatherDTO
import com.example.weatherapp.domain.enums.DayOrNightEnum
import com.example.weatherapp.domain.enums.WindDirectionsEnum

class CurrentWeatherMapper {
    fun map(
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
}