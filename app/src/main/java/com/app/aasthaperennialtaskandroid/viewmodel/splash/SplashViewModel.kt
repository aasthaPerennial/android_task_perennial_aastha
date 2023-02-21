package com.app.aasthaperennialtaskandroid.viewmodel.splash

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.aasthaperennialtaskandroid.model.UserModel
import com.app.aasthaperennialtaskandroid.repository.TaskRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

class SplashViewModel @Inject constructor():ViewModel() {
    var liveData: MutableLiveData<UserModel> = MutableLiveData()

    fun initSplashScreen() {
        viewModelScope.launch {
            delay(2000)
            updateLiveData()
        }
    }

    private fun updateLiveData() {
        val splashModel = UserModel(
            isUserLogin = false,
            isUserFirstTimeVisit = false,
            firstName = "",
            lastName = "",
            email = "",
            password = ""
        )
        liveData.value = splashModel
    }

}