package com.app.aasthaperennialtaskandroid.view.home

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.app.aasthaperennialtaskandroid.R
import com.app.aasthaperennialtaskandroid.database.TaskDatabase
import com.app.aasthaperennialtaskandroid.databinding.ActivityHomeBinding
import com.app.aasthaperennialtaskandroid.network.RetrofitHelper
import com.app.aasthaperennialtaskandroid.network.TaskService
import com.app.aasthaperennialtaskandroid.repository.TaskRepository
import com.app.aasthaperennialtaskandroid.viewmodel.home.HomeViewModel
import com.app.aasthaperennialtaskandroid.viewmodel.home.HomeViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {
    private lateinit var homeViewModel: HomeViewModel
    private lateinit var homeBinding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        homeBinding = DataBindingUtil.setContentView(this, R.layout.activity_home)

        val taskService = RetrofitHelper.getInstance().create(TaskService::class.java)
        val taskDatabase = TaskDatabase.getDatabase(applicationContext)

        val repository = TaskRepository(taskDatabase, taskService)
        initializeDagger()
        homeViewModel.weatherResponce.observe(this) {
            Log.d("API_RESPONSE", it.toString())
        }
    }

    @Inject
    lateinit var viewModelProvider: ViewModelProvider.Factory


    fun initializeDagger() {
        homeViewModel = ViewModelProvider(this, viewModelProvider).get(HomeViewModel::class.java)
    }

}