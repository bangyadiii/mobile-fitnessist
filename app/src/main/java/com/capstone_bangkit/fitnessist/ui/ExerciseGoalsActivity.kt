package com.capstone_bangkit.fitnessist.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.capstone_bangkit.fitnessist.R
import com.capstone_bangkit.fitnessist.databinding.ActivityExerciseGoalsBinding

class ExerciseGoalsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityExerciseGoalsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExerciseGoalsBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}