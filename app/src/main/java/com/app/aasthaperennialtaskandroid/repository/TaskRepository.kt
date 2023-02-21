package com.app.aasthaperennialtaskandroid.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.app.aasthaperennialtaskandroid.database.TaskDatabase
import com.app.aasthaperennialtaskandroid.model.UserModel
import com.app.aasthaperennialtaskandroid.model.WeatherResponce
import com.app.aasthaperennialtaskandroid.network.TaskService

class TaskRepository(private val taskDatabase: TaskDatabase, private val service: TaskService) {
    private val userLiveData = MutableLiveData<UserModel>()

    val userModel: LiveData<UserModel>
        get() = userLiveData

    private val weatherLiveData = MutableLiveData<WeatherResponce>()

    val weather: LiveData<WeatherResponce>
        get() = weatherLiveData

    suspend fun getUser() {
        val userModel = taskDatabase.getUserDao().getUser()
        userLiveData.postValue(userModel[0])
    }

    suspend fun getWeather(lat: Double, lon: Double, appId: String) {
        val result = service.getWeather(lat, lon, appId)
        if (result.body() != null) {
            weatherLiveData.postValue(result.body())
        }
    }

}