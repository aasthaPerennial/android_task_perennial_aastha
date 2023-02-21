package com.app.aasthaperennialtaskandroid.view.splash

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.app.aasthaperennialtaskandroid.R
import com.app.aasthaperennialtaskandroid.databinding.ActivitySplashBinding
import com.app.aasthaperennialtaskandroid.model.UserModel
import com.app.aasthaperennialtaskandroid.view.home.HomeActivity
import com.app.aasthaperennialtaskandroid.viewmodel.splash.SplashViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashActivity : AppCompatActivity() {
    private lateinit var splashViewModel: SplashViewModel
    private lateinit var splashBinding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        splashBinding = DataBindingUtil.setContentView(this, R.layout.activity_splash)
        initViewModel()
        observeSplashLiveData()
    }

    private fun initViewModel() {
        splashViewModel = ViewModelProvider(this).get(SplashViewModel::class.java)
    }

    private fun observeSplashLiveData() {
        splashViewModel.initSplashScreen()
        val observer = Observer<UserModel> {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }
        splashViewModel.liveData.observe(this, observer)
    }
}