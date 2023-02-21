package com.app.aasthaperennialtaskandroid.viewmodel.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.app.aasthaperennialtaskandroid.repository.TaskRepository

class HomeViewModelFactory(private val repository: TaskRepository) :
    ViewModelProvider.AndroidViewModelFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return HomeViewModel(repository) as T
    }
}
