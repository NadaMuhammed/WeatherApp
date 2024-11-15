package com.example.weatherapp.data.api

import com.example.weatherapp.data.model.WeeklyForecastResponse
import retrofit2.http.GET
import retrofit2.http.Query

fun interface CurrentWeatherApi {

    @GET("forecast.json")
    suspend fun getWeeklyAndDailyWeather(
        @Query("q") country: String,
        @Query("days") days: Int?
    ): WeeklyForecastResponse
}