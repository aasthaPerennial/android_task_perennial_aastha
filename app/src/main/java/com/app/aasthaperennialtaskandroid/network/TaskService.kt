package com.app.aasthaperennialtaskandroid.network

import com.app.aasthaperennialtaskandroid.model.WeatherResponce
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TaskService {

    @GET("/weather")
    suspend fun getWeather(@Query("lat") lat:Double, @Query("lon") lon:Double,
                           @Query("appId") appId:String):Response<WeatherResponce>
    // https://api.openweathermap.org/data/2.5/weather?lat=44.34&lon=10.99&appid={API key}
}