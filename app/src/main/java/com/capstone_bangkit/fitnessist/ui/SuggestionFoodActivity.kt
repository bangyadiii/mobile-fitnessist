package com.capstone_bangkit.fitnessist.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.capstone_bangkit.fitnessist.databinding.ActivitySuggestionFoodBinding

class SuggestionFoodActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySuggestionFoodBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySuggestionFoodBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}