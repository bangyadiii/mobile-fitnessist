package com.capstone_bangkit.fitnessist.ui

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.capstone_bangkit.fitnessist.R
import com.capstone_bangkit.fitnessist.databinding.ActivityInstructionCameraScanBinding
import com.capstone_bangkit.fitnessist.rotateFile
import java.io.File

class InstructionCameraScanActivity : AppCompatActivity() {
    private lateinit var binding: ActivityInstructionCameraScanBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInstructionCameraScanBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnScanFood.setOnClickListener {
            val upload = Intent(this@InstructionCameraScanActivity, UploadActivity::class.java)
            startActivity(upload)
        }
        binding.back.setOnClickListener {
            onBackPressed()
        }
    }
}