package com.capstone_bangkit.fitnessist.ui

import android.app.Application
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.capstone_bangkit.fitnessist.MainActivity
import com.capstone_bangkit.fitnessist.R
import com.capstone_bangkit.fitnessist.api.ApiConfig
import com.capstone_bangkit.fitnessist.api.LoginRequest
import com.capstone_bangkit.fitnessist.api.LoginResponse
import com.capstone_bangkit.fitnessist.api.RegisterRequest
import com.capstone_bangkit.fitnessist.api.RegisterResponse
import com.capstone_bangkit.fitnessist.authentication.AuthenticationManager
import com.capstone_bangkit.fitnessist.authentication.AuthenticationViewModel
import com.capstone_bangkit.fitnessist.databinding.ActivityLoginBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
    private lateinit var authentication: AuthenticationManager
    private lateinit var authenticationViewModel: AuthenticationViewModel
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        authenticationViewModel = ViewModelProvider(this)[AuthenticationViewModel::class.java]
        supportActionBar?.hide()
        authentication = AuthenticationManager(this)

        binding.btnRegister.setOnClickListener {
            val register = Intent(this@LoginActivity, RegisterActivity::class.java)
            startActivity(register)
        }

        binding.btnLogin.setOnClickListener {
            loginUser()
        }
    }
    private fun loginUser() {
        showLoading(true)
        val email = binding.edtEmail.text.toString().trim()
        val password = binding.edtPassword.text.toString().trim()

        authenticationViewModel.login(email, password,
            onSuccess = { token ->
                authentication.apply {
                    setSession(AuthenticationManager.SESSION, true)
                    login(AuthenticationManager.TOKEN, token)
                    login(AuthenticationManager.EMAIL, email)

                    Toast.makeText(this@LoginActivity, getString(R.string.success_login), Toast.LENGTH_SHORT).show()
                    showLoading(false)
                    val login = Intent(this@LoginActivity, MainActivity::class.java)
                    startActivity(login)
                    finishAffinity()
                }
            }, onError = { errorMessage ->
                showLoading(false)
                Toast.makeText(this@LoginActivity, errorMessage, Toast.LENGTH_SHORT).show()
            })
    }

    private fun showLoading(state: Boolean) {
        binding.progressBar.visibility = if (state) View.VISIBLE else View.GONE
    }

    override fun onStart() {
        super.onStart()
        if (authentication.checkSession(AuthenticationManager.SESSION) == true) {
            val login = Intent(this@LoginActivity, MainActivity::class.java)
            startActivity(login)
            finishAffinity()
        }
    }
}