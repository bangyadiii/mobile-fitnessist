package com.capstone_bangkit.fitnessist.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.capstone_bangkit.fitnessist.R
import com.capstone_bangkit.fitnessist.authentication.AuthenticationManager

class SplashScreenActivity : AppCompatActivity() {
    private val SPLASH_TIME_OUT: Long = 1000 //1 detik
    private lateinit var authentication: AuthenticationManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        supportActionBar?.hide()

        Handler().postDelayed({
            val login = Intent(this@SplashScreenActivity, OnBoardingActivity::class.java)
            startActivity(login)
            finishAffinity()
        }, SPLASH_TIME_OUT)
    }
}