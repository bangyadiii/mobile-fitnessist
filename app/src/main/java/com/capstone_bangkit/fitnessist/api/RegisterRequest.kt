package com.capstone_bangkit.fitnessist.api

data class RegisterRequest(
    val email: String,
    val username: String,
    val name: String,
    val password: String,
    val passwordConfirmation: String
)
