package com.example.weatherapp.data.retrofit.response

import com.example.weatherapp.data.models.entity.others.Current
import com.example.weatherapp.data.models.entity.others.Forecast
import com.example.weatherapp.data.models.entity.others.Location

data class WeatherDaysResponse(
    val current: Current,
    val forecast: Forecast,
    val location: Location
)