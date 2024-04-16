package com.example.iubegresados.data.repository

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import com.example.iubegresados.data.model.User
import com.example.parcial_2_jg.data.remote.ApiClient
import com.example.parcial_2_jg.data.remote.ApiService
import retrofit2.Call

class UserRepository(application: Application) : AndroidViewModel(application) {
    private val apiClient = ApiClient().getApiService(application.applicationContext)
    fun getUserById(id: String): Call<User> {
        return apiClient.getUserBy(id)
    }
}
