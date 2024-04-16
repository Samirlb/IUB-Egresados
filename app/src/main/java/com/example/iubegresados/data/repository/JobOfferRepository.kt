package com.example.iubegresados.data.repository

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.iubegresados.data.model.JobOffer
import com.example.parcial_2_jg.data.remote.ApiClient
import retrofit2.Call

class JobOfferRepository(application: Application) : AndroidViewModel(application)  {
    private val apiClient = ApiClient().getApiService(application.applicationContext)

    fun getJobOffers(): Call<List<JobOffer>> {
        return apiClient.getJobOffers()
    }
}