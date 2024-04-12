package com.example.iubegresados.ui.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.iubegresados.R
import com.example.iubegresados.data.repository.LoginRepository
import com.example.iubegresados.ui.viewModels.LoginViewModel
import com.google.gson.Gson
import okhttp3.Call
import okhttp3.Callback
import okhttp3.Response
import java.io.IOException

class Login : AppCompatActivity() {
    private lateinit var loginButton: Button
    private lateinit var forgotPassword: Button
    private lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        loginViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

        loginButton = findViewById(R.id.logInButton)
        forgotPassword = findViewById(R.id.forgotPasswordButton)

        loginButton.setOnClickListener {
            val email = findViewById<EditText>(R.id.loginEmailText).text.toString()
            val password = findViewById<EditText>(R.id.loginPasswordText).text.toString()

            // Call the login function passing email and password
            Log.d("Login", "Pressed login button")
            login(email, password)
        }
    }

    private fun login(email: String, password: String) {
        loginViewModel.getLogin(email, password)

        loginViewModel.loginInfo.observe(this){ loginInfo->
            if (loginInfo.access_token.isNotEmpty()) {
                saveUser(email, password)
                goToHome()
            } else {
                Toast.makeText(this, "Invalid email or password", Toast.LENGTH_SHORT).show()
            }
        }
    }


    private fun saveUser(email: String, password: String) {
        // Implement your logic to save user data
    }

    private fun goToHome() {
        startActivity(Intent(this, Home::class.java))
        finish()
    }
}

data class LoginRequest(val username: String, val password: String)
data class LoginResponse(val success: Boolean)
