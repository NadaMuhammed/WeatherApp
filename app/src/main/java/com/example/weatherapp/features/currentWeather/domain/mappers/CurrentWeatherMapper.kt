package com.example.weatherapp.features.currentWeather.domain.mappers

import android.util.Log
import com.example.weatherapp.features.currentWeather.data.model.CurrentWeatherResponse
import com.example.weatherapp.features.currentWeather.domain.entities.CurrentWeatherDTO
import com.example.weatherapp.features.currentWeather.domain.enums.DayOrNightEnum

class CurrentWeatherMapper {
    fun map(currentWeatherResponse: CurrentWeatherResponse): CurrentWeatherDTO {
        return with(currentWeatherResponse) {
            Log.e("temperatureInCelsius", current.temperatureInCelsius.toString())
            Log.e("name", location.name.toString())
            Log.e("latitude", location.latitude.toString())
            CurrentWeatherDTO(
                name = location.name,
                region = location.region,
                country = location.country,
                temperature = current.temperatureInCelsius,
                isDayOrNight = DayOrNightEnum.fromIsDay(current.isDay),
                condition = current.condition.text,
                windDirection = current.windDirection,
                humidity = current.humidity
            )
        }
    }
}