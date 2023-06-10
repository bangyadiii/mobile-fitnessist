package com.capstone_bangkit.fitnessist.authentication

import android.app.Application
import android.content.Intent
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import com.capstone_bangkit.fitnessist.MainActivity
import com.capstone_bangkit.fitnessist.R
import com.capstone_bangkit.fitnessist.api.ApiConfig
import com.capstone_bangkit.fitnessist.api.LoginRequest
import com.capstone_bangkit.fitnessist.api.LoginResponse
import com.capstone_bangkit.fitnessist.api.RegisterRequest
import com.capstone_bangkit.fitnessist.api.RegisterResponse
import com.capstone_bangkit.fitnessist.ui.LoginActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AuthenticationViewModel(application: Application) : AndroidViewModel(application) {
    fun login(email: String, password: String, onSuccess: (String) -> Unit, onError: (String) -> Unit) {
        // Create RegisterRequest object
        val request = LoginRequest(email, password)

        // Handle API response
        ApiConfig.getApiService().authenticationLogin(request).enqueue(object :
            Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                if (password.isNotEmpty() && email.isNotEmpty()) {
                    when(response.code()) {
                        200 -> {
                            val token = response.body()?.data!!.token
                            onSuccess(token)
                        }
                        400 -> { onError(getApplication<Application>().getString(R.string.check_input)) }
                        401 -> { onError(getApplication<Application>().getString(R.string.email_password_not_found)) }
                        else -> { onError(getApplication<Application>().getString(R.string.server_error)) }
                    }
                } else if (email.isEmpty()) {
                    onError(getApplication<Application>().getString(R.string.empty_email))
                } else if (password.isEmpty()) {
                    onError(getApplication<Application>().getString(R.string.empty_password))
                }
            }
            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                onError(getApplication<Application>().getString(R.string.server_error))
            }
        })
    }

    fun register(username: String, name: String, email: String, password: String, passwordConfirmation: String, onSuccess: () -> Unit, onError: (String) -> Unit) {
        // Create RegisterRequest object
        val request = RegisterRequest(email, username, name, password, passwordConfirmation)

        // Handle API response
        ApiConfig.getApiService().authenticationRegister(request).enqueue(object : Callback<RegisterResponse> {
            override fun onResponse(call: Call<RegisterResponse>, response: Response<RegisterResponse>) {
                if (passwordConfirmation == password) {
                    if (username.isNotEmpty() && name.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty()) {
                        when(response.code()) {
                            201 -> {
                                onSuccess()
                            } 400 -> { onError(getApplication<Application>().getString(R.string.email_have_been_registered)) }
                            else -> { onError(getApplication<Application>().getString(R.string.server_error)) }
                        }
                    } else if (username.isEmpty()) {
                        onError(getApplication<Application>().getString(R.string.empty_username))
                    } else if (name.isEmpty()) {
                        onError(getApplication<Application>().getString(R.string.empty_name))
                    } else if (email.isEmpty()) {
                        onError(getApplication<Application>().getString(R.string.empty_email))
                    } else if (password.isEmpty()) {
                        onError(getApplication<Application>().getString(R.string.empty_password))
                    } else {
                        onError(getApplication<Application>().getString(R.string.check_input))
                    }
                } else if (password.isEmpty()) {
                    onError(getApplication<Application>().getString(R.string.empty_password))
                } else if (passwordConfirmation.isEmpty()) {
                    onError(getApplication<Application>().getString(R.string.empty_passconf))
                } else {
                    onError(getApplication<Application>().getString(R.string.password_passconf_must_same))
                }
            }

            override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
                onError(getApplication<Application>().getString(R.string.server_error))
            }
        })
    }

}