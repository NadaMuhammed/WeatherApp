package com.example.weatherapp.domain.mappers

import com.example.weatherapp.data.model.CurrentWeatherResponse
import com.example.weatherapp.domain.entities.CurrentWeatherDTO
import com.example.weatherapp.domain.enums.ConditionEnum
import com.example.weatherapp.domain.enums.DayOrNightEnum
import com.example.weatherapp.domain.enums.WindDirectionsEnum

class CurrentWeatherMapper {
    fun map(currentWeatherResponse: CurrentWeatherResponse): CurrentWeatherDTO {
        return with(currentWeatherResponse) {
            CurrentWeatherDTO(
                name = location.name,
                region = location.region,
                country = location.country,
                temperature = current.temperatureInCelsius,
                isDayOrNight = DayOrNightEnum.fromIsDay(current.isDay),
                condition = ConditionEnum.fromCondition(isCloudy = current.cloud, isDay = current.isDay),
                conditionText = current.condition.text,
                windDirection = WindDirectionsEnum.fromWindDirection(current.windDirection ?: "").name,
                humidity = current.humidity
            )
        }
    }
}