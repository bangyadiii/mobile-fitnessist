package com.capstone_bangkit.fitnessist.api


import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

@Keep
data class ResponseJSON<T>(
    @SerializedName("data")
    @Expose
    val `data`: T?,

    @SerializedName("status")
    @Expose
    val status: Status?
)