package com.capstone_bangkit.fitnessist.model

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("accessToken")
    val token: String
)
