package com.example.iubegresados.data.repository

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.iubegresados.data.model.Company
import com.example.parcial_2_jg.data.remote.ApiClient
import retrofit2.Call
class CompanyRepository(application: Application) : AndroidViewModel(application)  {
    private val apiClient = ApiClient().getApiService(application.applicationContext)

    fun getCompanyBy(id: String): Call<Company> {
        return apiClient.getCompanyBy(id)
    }
}