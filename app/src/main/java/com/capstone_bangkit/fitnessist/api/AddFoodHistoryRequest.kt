package com.capstone_bangkit.fitnessist.api

data class AddFoodHistoryRequest(
    val food_name: String,
    val food_id: String,
    val image_url: String,
    val calories_per_100gr: Double,
    val total_grams: Int,
    val total_calories: Double?
)
