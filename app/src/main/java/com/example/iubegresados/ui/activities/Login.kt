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
import com.example.iubegresados.data.model.SessionManager
import com.example.iubegresados.data.model.User
import com.example.iubegresados.data.model.AppSingleton
import com.example.iubegresados.data.repository.UserRepository
import com.example.iubegresados.ui.viewModels.LoginViewModel
import com.example.iubegresados.ui.viewModels.UserViewModel
import com.google.gson.Gson
import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts

class Login : AppCompatActivity() {
    private lateinit var loginButton: Button
    private lateinit var forgotPassword: Button
    private lateinit var loginViewModel: LoginViewModel
    private lateinit var userViewModel: UserViewModel
    private lateinit var sessionManager: SessionManager
    private lateinit var userRepository: UserRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        loginViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        userRepository = UserRepository(application)

        loginButton = findViewById(R.id.logInButton)
        forgotPassword = findViewById(R.id.forgotPasswordButton)
        sessionManager = SessionManager(this)

        if (sessionManager.fetchUser() != null) {
            goToHome()
            return
        }

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

        loginViewModel.loginInfo.observe(this) { loginInfo ->
            if (loginInfo.access_token.isNotEmpty()) {
                sessionManager.saveAuthToken(loginInfo.access_token)
                getUserDetails(loginInfo.access_token)
            } else {
                Toast.makeText(this, "Invalid email or password", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun getUserDetails(token: String) {
        val userId = decodeTokenAndGetUserId(token)
        userViewModel.getUserBy(userId)

        userViewModel.userInfo.observe(this) { user ->
            user.userid = userId.toString()
            AppSingleton.user = user
            saveUser(user)
            goToHome()
        }
    }

    private fun saveUser(user: User) {
        val gson = Gson()
        val userJson = gson.toJson(user)
        sessionManager.saveUser(userJson)
    }

    private fun decodeTokenAndGetUserId(token: String): String {
        // Parse the token
        val claims: Claims = Jwts.parserBuilder()
            .setSigningKey("a629d8276b72b7c8cad02eee54b1dd2da059a37f782ff7fe517435ae6ef763f1".toByteArray())
            .build()
            .parseClaimsJws(token)
            .body

        // Extract the user ID from the claims
        val userId: String = claims["id"].toString()

        return userId
    }

    private fun goToHome() {
        startActivity(Intent(this, Home::class.java))
        finish()
    }
}


data class LoginRequest(val username: String, val password: String)
data class LoginResponse(val success: Boolean)
