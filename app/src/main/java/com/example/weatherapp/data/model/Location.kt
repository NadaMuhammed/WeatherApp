package com.example.weatherapp.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

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