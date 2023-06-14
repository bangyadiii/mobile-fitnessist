package com.capstone_bangkit.fitnessist.model

data class GetFoodHistory(
    val id: String,
    val user_id: String,
    val image_url: String,
    val food_id: String,
    val food_name: String,
    val total_calories: Double?,
    val total_grams: Int,
    val calories_per_100gr: Double?,
    val created_at: String,
    val updated_at: String
)
