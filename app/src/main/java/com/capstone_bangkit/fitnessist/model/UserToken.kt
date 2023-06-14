package com.capstone_bangkit.fitnessist.model

import com.google.gson.annotations.SerializedName

data class UserToken(
    @SerializedName("accessToken")
    val token: String
)
