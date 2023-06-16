package com.capstone_bangkit.fitnessist.api


import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

@Keep
data class LinksPagination(
    @SerializedName("next")
    @Expose
    val next: String?,
    @SerializedName("prev")
    @Expose
    val prev: String?
)