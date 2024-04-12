package com.example.iubegresados.ui.viewModels

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.iubegresados.data.model.JobOffer
import com.example.iubegresados.data.repository.JobOfferRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class JobOfferViewModel(application: Application): AndroidViewModel(application) {
    private val job = JobOfferRepository(application)
    private val _jobOffers = MutableLiveData<List<JobOffer>>()
    val jobOffers: MutableLiveData<List<JobOffer>>
        get() = _jobOffers

    fun getJobOffers() {
        job.getJobOffers().enqueue(object : Callback<List<JobOffer>> {
            override fun onResponse(
                call: Call<List<JobOffer>>,
                response: Response<List<JobOffer>>
            ) {
                if (response.isSuccessful) {
                    _jobOffers.value = response.body()
                } else {
                    Log.d("JobOfferViewModel", "Error: ${response.errorBody()}")
                }
            }

            override fun onFailure(call: Call<List<JobOffer>>, t: Throwable) {
                Log.d("JobOfferViewModel", "Error: ${t.toString()}")
            }

        })
    }
}