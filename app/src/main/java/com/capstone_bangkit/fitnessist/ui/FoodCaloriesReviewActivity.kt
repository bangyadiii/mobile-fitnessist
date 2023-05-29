package com.capstone_bangkit.fitnessist.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.capstone_bangkit.fitnessist.R
import com.capstone_bangkit.fitnessist.databinding.ActivityFoodCaloriesReviewBinding

class FoodCaloriesReviewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFoodCaloriesReviewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFoodCaloriesReviewBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}