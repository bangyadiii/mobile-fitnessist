package com.capstone_bangkit.fitnessist.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.capstone_bangkit.fitnessist.R
import com.capstone_bangkit.fitnessist.databinding.FragmentWorkoutBinding

class WorkoutFragment : Fragment() {
    private lateinit var binding: FragmentWorkoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWorkoutBinding.inflate(inflater, container, false)
        return binding.root
    }
}