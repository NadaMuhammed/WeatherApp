package com.example.weatherapp.data.api

import com.example.weatherapp.data.model.CurrentWeatherResponse
import com.example.weatherapp.data.model.WeeklyForecastResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface CurrentWeatherApi {

    @GET("current.json")
    suspend fun getCurrentWeather(@Query("q") country: String): CurrentWeatherResponse

    @GET("forecast.json")
    suspend fun getWeeklyAndDailyWeather(
        @Query("q") country: String,
        @Query("days") days: Int? = 7
    ): WeeklyForecastResponse
}