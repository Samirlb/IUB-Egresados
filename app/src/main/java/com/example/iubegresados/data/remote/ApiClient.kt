package com.example.parcial_2_jg.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://project-storm-backend.onrender.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getApiService(): ApiService {
        return retrofit.create(ApiService::class.java)
    }
}