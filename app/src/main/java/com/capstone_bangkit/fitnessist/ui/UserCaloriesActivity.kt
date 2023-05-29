package com.capstone_bangkit.fitnessist.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.capstone_bangkit.fitnessist.R
import com.capstone_bangkit.fitnessist.databinding.ActivityUserCaloriesBinding

class UserCaloriesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUserCaloriesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserCaloriesBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}