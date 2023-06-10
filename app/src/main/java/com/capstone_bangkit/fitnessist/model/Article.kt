package com.capstone_bangkit.fitnessist.model

data class Article(
    val id: Long,
    val createdAt: String,
    val photoUrl: String,
    val title: String,
    val description: String
)