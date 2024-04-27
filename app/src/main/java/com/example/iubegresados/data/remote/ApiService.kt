package com.example.parcial_2_jg.data.remote

import android.content.Context
import android.content.SharedPreferences
import com.example.iubegresados.data.model.ApplicantResponse
import com.example.iubegresados.data.model.Company
import com.example.iubegresados.data.model.JobOffer
import com.example.iubegresados.data.model.Login
import com.example.iubegresados.data.model.User
import com.example.iubegresados.data.repository.ApplicantRequest
import retrofit2.Call
import retrofit2.http.*

interface ApiService {
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

    @GET("get_company/{id}")
    fun getCompanyBy(id: String): Call<Company>

    @POST("create_applicant")
    fun createApplicant(@Body request: ApplicantRequest): Call<ApplicantResponse>

}
