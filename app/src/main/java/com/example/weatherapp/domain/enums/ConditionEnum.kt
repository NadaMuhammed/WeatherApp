package com.example.weatherapp.domain.enums

enum class ConditionEnum {
    Sunny,
    Cloudy,
    Rainy,
    ClearNight,
    Snowy,
    Unknown;

    companion object {
        fun fromCondition(isDay: DayOrNightEnum?, condition: String?): ConditionEnum {
            return when {
                condition.isNullOrEmpty() -> Unknown
                "clear" in condition && isDay == DayOrNightEnum.Night -> ClearNight
                "cloud" in condition || "overcast" in condition || "wind" in condition || "mist" in condition -> Cloudy
                ("clear" in condition || "sunny" in condition) && isDay == DayOrNightEnum.Day -> Sunny
                "snow" in condition -> Snowy
                "rain" in condition -> Rainy
                else -> Unknown
            }
        }
    }
}