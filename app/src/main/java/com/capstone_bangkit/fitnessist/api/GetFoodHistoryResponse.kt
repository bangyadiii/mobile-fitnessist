package com.capstone_bangkit.fitnessist.api

import com.capstone_bangkit.fitnessist.model.GetFoodHistory

class GetFoodHistoryResponse (
    val status: StatusResponse,
    val data: List<GetFoodHistory>
)