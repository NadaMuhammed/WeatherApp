package com.example.weatherapp.features.currentWeather.domain.mappers

import com.example.weatherapp.features.currentWeather.data.model.CurrentWeatherResponse
import com.example.weatherapp.features.currentWeather.domain.entities.CurrentWeatherDTO
import com.example.weatherapp.features.currentWeather.domain.enums.DayOrNightEnum

class CurrentWeatherMapper {
    fun map(currentWeatherResponse: CurrentWeatherResponse): CurrentWeatherDTO {
        return with(currentWeatherResponse) {
            CurrentWeatherDTO(
                name = location.name,
                region = location.region,
                country = location.country,
                temperature = currentWeather.temperatureInCelsius,
                isDayOrNight = DayOrNightEnum.fromIsDay(currentWeather.isDay),
                condition = currentWeather.condition.text,
                windDirection = currentWeather.windDirection,
                humidity = currentWeather.humidity
            )
        }
    }
}