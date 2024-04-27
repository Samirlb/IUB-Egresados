package com.example.iubegresados.data.repository

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.iubegresados.data.model.ApplicantResponse
import com.example.parcial_2_jg.data.remote.ApiClient

class ApplicantRepository(application: Application) : AndroidViewModel(application)  {
    private val apiClient = ApiClient().getApiService(application.applicationContext)

    fun applyJobOffer(jobOfferId: String, userId: String): retrofit2.Call<ApplicantResponse> {
        val applicantRequest = ApplicantRequest(jobOfferId, userId)
        return apiClient.createApplicant(applicantRequest)
    }
}

data class ApplicantRequest(
    val offerid: String,
    val userid: String
)