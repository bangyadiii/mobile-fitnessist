package com.capstone_bangkit.fitnessist.model

import com.google.gson.annotations.SerializedName

data class Article(
    @SerializedName("id")
    val id: String,
    @SerializedName("createdAt")
    val createdAt: String,
    @SerializedName("photoUrl")
    val photoUrl: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("description")
    val description: String
)