package com.capstone_bangkit.fitnessist.model

data class UserData(
    val id: String,
    val username: String,
    val name: String,
    val email: String,
    val my_inventory: Map<String, Any>
)
