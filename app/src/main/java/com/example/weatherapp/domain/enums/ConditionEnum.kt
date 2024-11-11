package com.example.weatherapp.domain.enums

enum class ConditionEnum {
    Sunny,
    Cloudy,
    Night;

    companion object {
        fun fromCondition(isCloudy: Int? = -1, isDay: Int? = -1): ConditionEnum {
            return if (isDay == 1) {
                Sunny
            } else if (isDay == 1 && isCloudy == 1) {
                Cloudy
            } else {
                Night
            }
        }
    }
}