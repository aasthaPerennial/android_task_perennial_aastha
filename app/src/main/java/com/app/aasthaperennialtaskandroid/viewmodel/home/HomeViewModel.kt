package com.app.aasthaperennialtaskandroid.viewmodel.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.aasthaperennialtaskandroid.model.WeatherResponce
import com.app.aasthaperennialtaskandroid.repository.TaskRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeViewModel @Inject constructor(private val repository: TaskRepository) : ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO) {
            // Mention your appId from OpenWeather (https://openweathermap.org/current)
            repository.getWeather(44.34, 10.99, "")
        }
    }

    val weatherResponce: LiveData<WeatherResponce>
        get() = repository.weather
}