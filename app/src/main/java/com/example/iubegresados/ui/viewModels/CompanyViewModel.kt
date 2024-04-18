package com.example.iubegresados.ui.viewModels

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.iubegresados.data.model.Company
import com.example.iubegresados.data.model.User
import com.example.iubegresados.data.repository.CompanyRepository
import com.example.iubegresados.data.repository.UserRepository
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
class CompanyViewModel(application: Application): AndroidViewModel(application) {
    private val companyRepository = CompanyRepository(application)
    private val _companyInfo = MutableLiveData<Company>()
    val companyInfo: MutableLiveData<Company>
        get() = _companyInfo

    fun getCompanyBy(id: String) {
        viewModelScope.launch {
            val company = companyRepository.getCompanyBy(id).enqueue(object : Callback<Company> {
                override fun onResponse(
                    call: Call<Company>,
                    response: Response<Company>
                ) {
                    if (response.isSuccessful) {
                        _companyInfo.value = response.body()
                    } else {
                        Log.d("CompanyViewModel", "Error: ${response.errorBody()}")
                    }
                }

                override fun onFailure(call: Call<Company>, t: Throwable) {
                    Log.d("CompanyViewModel", "Fail: ${t.message.toString()}")
                }

            })
        }
    }
}