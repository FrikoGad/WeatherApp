package com.example.weatherapp.data.retrofit.response

import com.example.weatherapp.data.models.entity.current.Current
import com.example.weatherapp.data.models.entity.current.Location

data class WeatherResponse(
    val current: Current,
    val location: Location
)