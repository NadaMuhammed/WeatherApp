package com.example.weatherapp.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

data class WeeklyForecastResponse(
    val location: Location,
    val current: CurrentWeather,
    val forecast: List<Forecast>
)

data class Forecast(
    val forecastDay: List<ForecastDay>? = emptyList()
)

data class ForecastDay(
    val date: String? = null,
    val day: DailyWeather? = null,
    val hour: List<HourlyWeather>? = emptyList()
)

@JsonClass(generateAdapter = true)
data class DailyWeather(
    @Json(name = "maxtemp_c") val maxTempInCelsius: Double? = 0.0,
    @Json(name = "maxtemp_f") val maxTempInFahrenheit: Double? = 0.0,
    @Json(name = "mintemp_c") val minTempInCelsius: Double? = 0.0,
    @Json(name = "mintemp_f") val minTempInFahrenheit: Double? = 0.0,
    @Json(name = "avgtemp_c") val avgTempInCelsius: Double? = 0.0,
    @Json(name = "avgtemp_f") val avgTempInFahrenheit: Double? = 0.0,
    @Json(name = "avghumidity") val avgHumidity: Double? = 0.0,
    @Json(name = "daily_will_it_rain") val willRain: Int? = 0,
    @Json(name = "daily_will_it_snow") val willSnow: Int? = 0,
    @Json(name = "condition") val condition: Condition? = null,
    @Json(name = "uv") val uv: Double? = 0.0
)

@JsonClass(generateAdapter = true)
data class HourlyWeather(
    @Json(name = "time") val time: String? = null,
    @Json(name = "temp_c") val temperatureInCelsius: Double? = 0.0,
    @Json(name = "temp_f") val temperatureInFahrenheit: Double? = 0.0,
    @Json(name = "is_day") val isDay: Int? = 0,
    @Json(name = "condition") val condition: Condition,
    @Json(name = "wind_degree") val windDegree: Int? = 0,
    @Json(name = "wind_dir") val windDirection: String? = null,
    @Json(name = "humidity") val humidity: Int? = 0,
    @Json(name = "cloud") val cloud: Int? = 0,
    @Json(name = "will_it_rain") val willRain: Int? = 0,
    @Json(name = "will_it_snow") val willSnow: Int? = 0,
    @Json(name = "uv") val uv: Double? = 0.0
)