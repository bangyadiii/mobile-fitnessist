package com.capstone_bangkit.fitnessist.api

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    @POST("auth/register")
    fun authenticationRegister(
        @Body request: RegisterRequest
    ): Call<RegisterResponse>

    @POST("auth/login")
    fun authenticationLogin(
        @Body request: LoginRequest
    ): Call<LoginResponse>

}