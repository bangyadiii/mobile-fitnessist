package com.capstone_bangkit.fitnessist.ui

import android.content.Intent
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

        var programId = ""
        binding.btnMenambahBeratBadan.setOnClickListener {
            Intent(this@ExerciseGoalsActivity, UserBodyDataActivity::class.java).also {
                it.putExtra(UserBodyDataActivity.PROGRAM_ID, "a58ef21c-922c-4a43-8d03-5ab6fe06d3e8")
            }
            val userBodyData = Intent(this@ExerciseGoalsActivity, UserBodyDataActivity::class.java)
            startActivity(userBodyData)
        }
        binding.btnMengurangiBeratBadan.setOnClickListener {
            Intent(this@ExerciseGoalsActivity, UserBodyDataActivity::class.java).also {
                it.putExtra(UserBodyDataActivity.PROGRAM_ID, "f6c26ad5-3e7a-4dd8-9e8e-ff40cf24649f")
            }
            val userBodyData = Intent(this@ExerciseGoalsActivity, UserBodyDataActivity::class.java)
            startActivity(userBodyData)
        }
        binding.btnJagaMasaOtot.setOnClickListener {
            Intent(this@ExerciseGoalsActivity, UserBodyDataActivity::class.java).also {
                it.putExtra(UserBodyDataActivity.PROGRAM_ID, "64c7d2dd-e2dd-4608-b3e4-aed91cd17f6a")
            }
            val userBodyData = Intent(this@ExerciseGoalsActivity, UserBodyDataActivity::class.java)
            startActivity(userBodyData)
        }
    }
}