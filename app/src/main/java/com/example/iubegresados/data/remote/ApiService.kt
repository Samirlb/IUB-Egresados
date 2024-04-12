package com.example.parcial_2_jg.data.remote

import com.example.iubegresados.data.model.JobOffer
import com.example.iubegresados.data.model.Login
import com.example.iubegresados.data.model.User
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @POST("login")
    @FormUrlEncoded
    fun login(
        @Field("username") email: String,
        @Field("password") password: String
    ): Call<Login>
    @GET("users/{id}")
    fun getUserBy(id: String): Call<User>

    @GET("get_job_offers")
    fun getJobOffers(): Call<List<JobOffer>>

}