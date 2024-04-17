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
        job.getJobOffers().enqueue(object : Callback<Map<String, List<JobOffer>>> {
            override fun onResponse(
                call: Call<Map<String, List<JobOffer>>>,
                response: Response<Map<String, List<JobOffer>>>
            ) {
                if (response.isSuccessful) {
                    val responseBody = response.body()
                    if (responseBody != null) {
                        // Extract the "resultado" array from the response
                        val resultadoArray = responseBody["resultado"]
                        if (resultadoArray != null) {
                            _jobOffers.value = resultadoArray
                        } else {
                            Log.d("JobOfferViewModel", "Failed to parse 'resultado' array")
                        }
                    } else {
                        Log.d("JobOfferViewModel", "Response body is null")
                    }
                } else {
                    Log.d("JobOfferViewModel", "Error: ${response.errorBody()}")
                }
            }



            override fun onFailure(call: Call<Map<String, List<JobOffer>>>, t: Throwable) {
                Log.d("JobOfferViewModel", "Fail: ${t.message.toString()}")
            }

        })
    }
}