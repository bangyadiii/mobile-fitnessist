package com.capstone_bangkit.fitnessist.api

import com.capstone_bangkit.fitnessist.model.User
import com.google.gson.annotations.SerializedName

class LoginResponse (
    @SerializedName("loginResult")
    val loginResult: User
)