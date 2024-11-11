package com.example.weatherapp.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class CurrentWeather(
    @Json(name = "last_updated") val lastUpdated: String? = null,
    @Json(name = "temp_c") val temperatureInCelsius: Double? = 0.0,
    @Json(name = "temp_f") val temperatureInFahrenheit: Double? = 0.0,
    @Json(name = "is_day") val isDay: Int? = 0,
    @Json(name = "condition") val condition: Condition,
    @Json(name = "wind_degree") val windDegree: Int? = 0,
    @Json(name = "wind_dir") val windDirection: String? = null,
    @Json(name = "humidity") val humidity: Int? = 0,
    @Json(name = "cloud") val cloud: Int? = 0
)

@JsonClass(generateAdapter = true)
data class Condition(
    val text: String? = null,
    val icon: String? = null,
    val code: Long? = 0
)