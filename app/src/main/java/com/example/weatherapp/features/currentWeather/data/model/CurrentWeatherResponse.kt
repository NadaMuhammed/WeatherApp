package com.example.weatherapp.features.currentWeather.data.model

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CurrentWeatherResponse(
    val location: Location,
    val current: CurrentWeather
)

@Serializable
data class Location(
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("region")
    val region: String? = null,
    @SerializedName("country")
    val country: String? = null,
    @SerializedName("lat")
    val latitude: Double? = 0.0,
    @SerializedName("lon")
    val longitude: Double? = 0.0,
    @SerializedName("tz_id")
    val timeZone: String? = null,
    @SerializedName("localtime_epoch")
    val localTimeInUnix: Long? = 0,
    @SerializedName("localtime")
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
    @SerializedName("last_updated_epoch")
    val unixLastUpdated: Long? = 0,
    @SerializedName("last_updated")
    val lastUpdated: String? = null,
    @SerializedName("temp_c")
    val temperatureInCelsius: Double? = 0.0,
    @SerializedName("temp_f")
    val temperatureInFahrenheit: Double? = 0.0,
    @SerializedName("is_day")
    val isDay: Int? = 0,
    @SerializedName("condition")
    val condition: Condition,
    @SerializedName("wind_mph")
    val windMilePerHour: Double? = 0.0,
    @SerializedName("wind_kph")
    val windKiloPerHour: Double? = 0.0,
    @SerializedName("wind_degree")
    val windDegree: Int? = 0,
    @SerializedName("wind_dir")
    val windDirection: String? = null,
    @SerializedName("pressure_mb")
    val pressureInMillibars: Double? = 0.0,
    @SerializedName("pressure_in")
    val pressureInInches: Double? = 0.0,
    @SerializedName("precip_mm")
    val precipitationInMillimeter: Double? = 0.0,
    @SerializedName("precip_in")
    val precipitationInInches: Double? = 0.0,
    @SerializedName("humidity")
    val humidity: Int? = 0,
    @SerializedName("cloud")
    val cloud: Int? = 0,
    @SerializedName("feelslike_c")
    val feelsLikeInCelsius: Double? = 0.0,
    @SerializedName("feelslike_f")
    val feelsLikeInFahrenheit: Double? = 0.0,
    @SerializedName("windchill_c")
    val windChillInCelsius: Double? = 0.0,
    @SerializedName("windchill_f")
    val windChillInFahrenheit: Double? = 0.0,
    @SerializedName("heatindex_c")
    val heatIndexInCelsius: Double? = 0.0,
    @SerializedName("heatindex_f")
    val heatIndexInFahrenheit: Double? = 0.0,
    @SerializedName("dewpoint_c")
    val dewPointInCelsius: Double? = 0.0,
    @SerializedName("dewpoint_f")
    val dewPointInFahrenheit: Double? = 0.0,
    @SerializedName("vis_km")
    val visibilityInKilometer: Double? = 0.0,
    @SerializedName("vis_miles")
    val visibilityInMiles: Double? = 0.0,
    @SerializedName("uv")
    val uvIndex: Double? = 0.0,
    @SerializedName("gust_mph")
    val windGustInMilesPerHour: Double? = 0.0,
    @SerializedName("gust_kph")
    val windGustInKilometersPerHour: Double? = 0.0,
)
