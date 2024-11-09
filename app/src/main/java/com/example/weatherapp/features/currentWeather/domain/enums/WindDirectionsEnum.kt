package com.example.weatherapp.features.currentWeather.domain.enums

enum class WindDirectionsEnum {
    North,
    South,
    East,
    West,
    Northeast,
    Northwest,
    Southeast,
    Southwest;

    companion object {
        fun fromWindDirection(windDirection: String): WindDirectionsEnum {
            return when (windDirection) {
                "N" -> North
                "S" -> South
                "E" -> East
                "W" -> West
                "NE" -> Northeast
                "NW" -> Northwest
                "SE" -> Southeast
                else -> Southwest
            }
        }
    }
}