package com.example.iubegresados.data.repository

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.iubegresados.data.model.Login
import com.example.parcial_2_jg.data.remote.ApiClient
import retrofit2.Call

class LoginRepository(application: Application) : AndroidViewModel(application) {
    private val apiClient = ApiClient().getApiService(application.applicationContext)

    fun getLoginInfo(email: String, password: String): Call<Login> {
        return apiClient.login(email, password)
    }
}