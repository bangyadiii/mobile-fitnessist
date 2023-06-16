package com.capstone_bangkit.fitnessist.api

import com.google.gson.annotations.SerializedName

data class AddMyProgramRequest(
    @SerializedName("program_id")
    val program_id: String,
)
