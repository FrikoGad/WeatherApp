package com.example.weatherapp.data.retrofit

import com.example.weatherapp.data.retrofit.response.WeatherResponse
import com.example.weatherapp.data.retrofit.response.WeatherDaysResponse
import com.example.weatherapp.utils.API_KEY
import com.example.weatherapp.utils.BASE_URL
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

// https://api.weatherapi.com/v1/forecast.json?key=f1e461295192489aa71174448220607&q=St. Peterburg&days=1&aqi=no&alerts=no
// https://api.weatherapi.com/v1/current.json?key=f1e461295192489aa71174448220607&q=St. Peterburg&aqi=no

interface ApiService {

    @GET("forecast.json")
    fun getDaysWeatherAsync(
        @Query("q") location: String,
        @Query("days") days: String = "5",
        @Query("aqi") aqi: String = "no",
        @Query("alerts") alerts: String = "no"
    ) : Deferred<WeatherDaysResponse>

    @GET("current.json")
    fun getCurrentWeatherAsync(
        @Query("q") location: String,
        @Query("aqi") aqi: String = "no",
    ) : Deferred<WeatherResponse>

    companion object {
        operator fun invoke(): ApiService {
            val requestInterceptor = Interceptor { chain ->
                val url = chain.request()
                    .url()
                    .newBuilder()
                    .addQueryParameter("key", API_KEY)
                    .build()
                val request =chain.request()
                    .newBuilder()
                    .url(url)
                    .build()
                return@Interceptor chain.proceed(request)
            }

            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(requestInterceptor)
                .build()

            return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService::class.java)
        }
    }
}