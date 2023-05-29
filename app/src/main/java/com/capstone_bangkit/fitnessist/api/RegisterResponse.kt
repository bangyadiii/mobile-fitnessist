package com.capstone_bangkit.fitnessist.api

import com.google.gson.annotations.SerializedName

class RegisterResponse (
    @SerializedName("error")
    val error: Boolean,
    @SerializedName("message")
    val message: String
)