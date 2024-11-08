package com.example.weatherapp.features.currentWeather.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CurrentWeatherResponse(
    val location: Location,
    val current: CurrentWeather
)

@JsonClass(generateAdapter = true)
data class Location(
    @Json(name = "name") val name: String? = null,
    @Json(name = "region") val region: String? = null,
    @Json(name = "country") val country: String? = null,
    @Json(name = "lat") val latitude: Double? = 0.0,
    @Json(name = "lon") val longitude: Double? = 0.0,
    @Json(name = "tz_id") val timeZone: String? = null,
    @Json(name = "localtime_epoch") val localTimeInUnix: Long? = 0,
    @Json(name = "localtime") val localTime: String? = null,
)

@JsonClass(generateAdapter = true)
data class Condition(
    val text: String? = null,
    val icon: String? = null,
    val code: Long? = 0
)

@JsonClass(generateAdapter = true)
data class CurrentWeather(
    @Json(name = "last_updated_epoch") val unixLastUpdated: Long? = 0,
    @Json(name = "last_updated") val lastUpdated: String? = null,
    @Json(name = "temp_c") val temperatureInCelsius: Double? = 0.0,
    @Json(name = "temp_f") val temperatureInFahrenheit: Double? = 0.0,
    @Json(name = "is_day") val isDay: Int? = 0,
    @Json(name = "condition") val condition: Condition,
    @Json(name = "wind_mph") val windMilePerHour: Double? = 0.0,
    @Json(name = "wind_kph") val windKiloPerHour: Double? = 0.0,
    @Json(name = "wind_degree") val windDegree: Int? = 0,
    @Json(name = "wind_dir") val windDirection: String? = null,
    @Json(name = "pressure_mb") val pressureInMillibars: Double? = 0.0,
    @Json(name = "pressure_in") val pressureInInches: Double? = 0.0,
    @Json(name = "precip_mm") val precipitationInMillimeter: Double? = 0.0,
    @Json(name = "precip_in") val precipitationInInches: Double? = 0.0,
    @Json(name = "humidity") val humidity: Int? = 0,
    @Json(name = "cloud") val cloud: Int? = 0,
    @Json(name = "feelslike_c") val feelsLikeInCelsius: Double? = 0.0,
    @Json(name = "feelslike_f") val feelsLikeInFahrenheit: Double? = 0.0,
    @Json(name = "windchill_c") val windChillInCelsius: Double? = 0.0,
    @Json(name = "windchill_f") val windChillInFahrenheit: Double? = 0.0,
    @Json(name = "heatindex_c") val heatIndexInCelsius: Double? = 0.0,
    @Json(name = "heatindex_f") val heatIndexInFahrenheit: Double? = 0.0,
    @Json(name = "dewpoint_c") val dewPointInCelsius: Double? = 0.0,
    @Json(name = "dewpoint_f") val dewPointInFahrenheit: Double? = 0.0,
    @Json(name = "vis_km") val visibilityInKilometer: Double? = 0.0,
    @Json(name = "vis_miles") val visibilityInMiles: Double? = 0.0,
    @Json(name = "uv") val uvIndex: Double? = 0.0,
    @Json(name = "gust_mph") val windGustInMilesPerHour: Double? = 0.0,
    @Json(name = "gust_kph") val windGustInKilometersPerHour: Double? = 0.0,
)
