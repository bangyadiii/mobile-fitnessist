package com.capstone_bangkit.fitnessist.api

import com.capstone_bangkit.fitnessist.model.UserToken
import com.google.gson.annotations.SerializedName

class LoginResponse (
    @SerializedName("data")
    val data: UserToken
)