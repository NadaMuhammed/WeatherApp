package com.example.weatherapp.domain.enums

enum class ConditionEnum {
    Sunny,
    Cloudy,
    Night;

    companion object {
        fun fromCondition(isCloudy: Boolean, isDay: Int? = -1): ConditionEnum {
            return if (isDay == 0) {
                Night
            } else {
                if (isCloudy)
                    Cloudy
                else
                    Sunny
            }
        }
    }
}