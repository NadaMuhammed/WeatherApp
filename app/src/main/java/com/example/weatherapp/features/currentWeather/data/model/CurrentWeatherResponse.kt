package com.example.weatherapp.features.currentWeather.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CurrentWeatherResponse(
    val location: Location,
    val current: Current
)


@Serializable
data class Location(
    @SerialName("name")
    val name: String? = null,
    @SerialName("region")
    val region: String? = null,
    @SerialName("country")
    val country: String? = null,
    @SerialName("lat")
    val latitude: Double? = 0.0,
    @SerialName("lon")
    val longitude: Double? = 0.0,
    @SerialName("tz_id")
    val timeZone: String? = null,
    @SerialName("localtime_epoch")
    val unixTime: Long? = 0,
    @SerialName("localtime")
    val localTime: String? = null
)

@Serializable
data class Condition(
    val text: String? = null,
    val icon: String? = null,
    val code: Long? = 0
)

@Serializable
data class Current(
    @SerialName("last_updated")
    val lastUpdated: String? = null,
    @SerialName("temp_c")
    val temperatureInCelsius: Double? = 24.0,
    @SerialName("temp_f")
    val temperatureInFahrenheit: Double? = 0.0,
    @SerialName("is_day")
    val isDay: Int? = 0,
    @SerialName("condition")
    val condition: Condition,
    @SerialName("wind_dir")
    val windDirection: String? = null,
    @SerialName("humidity")
    val humidity: Int? = 0,
    @SerialName("cloud")
    val cloud: Int? = 0,
)
