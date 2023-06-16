package com.capstone_bangkit.fitnessist.api


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep
import com.google.gson.annotations.Expose

@Keep
data class Status(
    @SerializedName("code")
    @Expose
    val code: Int?,
    @SerializedName("message")
    @Expose
    val message: String?
)