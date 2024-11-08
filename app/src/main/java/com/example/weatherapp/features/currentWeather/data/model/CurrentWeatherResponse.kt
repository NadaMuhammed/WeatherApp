package com.example.weatherapp.features.currentWeather.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CurrentWeatherResponse(
    val location: Location,
    val currentWeather: CurrentWeather
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
    val localTimeInUnix: Long? = 0,
    @SerialName("localtime")
    val localTime: String? = null,
)

@Serializable
data class Condition(
    val text: String? = null,
    val icon: String? = null,
    val code: Long? = 0
)

@Serializable
data class CurrentWeather(
    @SerialName("last_updated_epoch")
    val unixLastUpdated: Long? = 0,
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
    @SerialName("wind_mph")
    val windMilePerHour: Double? = 0.0,
    @SerialName("wind_kph")
    val windKiloPerHour: Double? = 0.0,
    @SerialName("wind_degree")
    val windDegree: Int? = 0,
    @SerialName("wind_dir")
    val windDirection: String? = null,
    @SerialName("pressure_mb")
    val pressureInMillibars: Double? = 0.0,
    @SerialName("pressure_in")
    val pressureInInches: Double? = 0.0,
    @SerialName("precip_mm")
    val precipitationInMillimeter: Double? = 0.0,
    @SerialName("precip_in")
    val precipitationInInches: Double? = 0.0,
    @SerialName("humidity")
    val humidity: Int? = 0,
    @SerialName("cloud")
    val cloud: Int? = 0,
    @SerialName("feelslike_c")
    val feelsLikeInCelsius: Double? = 0.0,
    @SerialName("feelslike_f")
    val feelsLikeInFahrenheit: Double? = 0.0,
    @SerialName("windchill_c")
    val windChillInCelsius: Double? = 0.0,
    @SerialName("windchill_f")
    val windChillInFahrenheit: Double? = 0.0,
    @SerialName("heatindex_c")
    val heatIndexInCelsius: Double? = 0.0,
    @SerialName("heatindex_f")
    val heatIndexInFahrenheit: Double? = 0.0,
    @SerialName("dewpoint_c")
    val dewPointInCelsius: Double? = 0.0,
    @SerialName("dewpoint_f")
    val dewPointInFahrenheit: Double? = 0.0,
    @SerialName("vis_km")
    val visibilityInKilometer: Double? = 0.0,
    @SerialName("vis_miles")
    val visibilityInMiles: Double? = 0.0,
    @SerialName("uv")
    val uvIndex: Double? = 0.0,
    @SerialName("gust_mph")
    val windGustInMilesPerHour: Double? = 0.0,
    @SerialName("gust_kph")
    val windGustInKilometersPerHour: Double? = 0.0,
)
