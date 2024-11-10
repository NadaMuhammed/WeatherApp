package com.example.weatherapp.features.currentWeather.domain.enums

enum class DayOrNightEnum(val isDay: Int) {
    Night(0),
    Day(1);

    companion object {
        fun fromIsDay(isDay: Int?): DayOrNightEnum {
            return entries.find { it.isDay == isDay } ?: Day
        }
    }
}