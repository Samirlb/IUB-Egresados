package com.example.iubegresados.ui.viewModels

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.iubegresados.data.model.ApplicantResponse
import com.example.iubegresados.data.repository.ApplicantRepository
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ApplicantsViewModel(application: Application): AndroidViewModel(application) {
    private val applicantRepository = ApplicantRepository(application)
    private val _applicantResponse = MutableLiveData<ApplicantResponse>()
    val applicantResponse: MutableLiveData<ApplicantResponse>
        get() = _applicantResponse

    fun applyJobOffer(userId: String, jobOfferId: String) {
        viewModelScope.launch {
            val company = applicantRepository.applyJobOffer(userId,jobOfferId).enqueue(object :
                Callback<ApplicantResponse> {
                override fun onResponse(
                    call: Call<ApplicantResponse>,
                    response: Response<ApplicantResponse>
                ) {
                    if (response.isSuccessful) {
                        _applicantResponse.value = response.body()
                    } else {
                        Log.d("CompanyViewModel", "Error: ${response.errorBody()}")
                    }
                }

                override fun onFailure(call: Call<ApplicantResponse>, t: Throwable) {
                    Log.d("CompanyViewModel", "Fail: ${t.message.toString()}")
                }

            })
        }
    }
}