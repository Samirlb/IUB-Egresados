package com.example.parcial_2_jg.data.remote

import android.content.Context
import android.content.SharedPreferences
import com.example.iubegresados.data.model.JobOffer
import com.example.iubegresados.data.model.Login
import com.example.iubegresados.data.model.User
import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    var sharedPreferences: SharedPreferences
    @POST("login")
    @FormUrlEncoded
    fun login(
        @Field("username") email: String,
        @Field("password") password: String
    ): Call<Login>

    @GET("get_user/{id}")
    fun getUserBy(@Path("id") id: String): Call<User>

    @GET("get_job_offers")
    fun getJobOffers(): Call<Map<String, List<JobOffer>>>
}
