package com.example.weatherapp.features.currentWeather.data.api

import com.example.weatherapp.features.currentWeather.data.model.CurrentWeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query

fun interface CurrentWeatherApi {

    @GET("/current.json")
    suspend fun getCurrentWeather(@Query("q") country: String): Result<CurrentWeatherResponse>
}