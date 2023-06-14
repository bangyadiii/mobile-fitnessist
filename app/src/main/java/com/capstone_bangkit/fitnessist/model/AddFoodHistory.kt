package com.capstone_bangkit.fitnessist.model

data class AddFoodHistory(
    val id: String,
    val user_id: String,
    val image_url: String,
    val food_id: String,
    val food_name: String,
    val total_calories: Int?,
    val total_grams: Int,
    val calories_per_100gr: Int,
    val created_at: String,
    val updated_at: String
)
