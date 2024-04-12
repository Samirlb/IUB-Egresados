package com.example.iubegresados.ui.viewModels

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.iubegresados.data.model.Login
import com.example.iubegresados.data.repository.LoginRepository
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginViewModel(application: Application): AndroidViewModel(application) {

    private val loginRepository = LoginRepository(application)
    private val _loginInfo = MutableLiveData<Login>()
    val loginInfo: MutableLiveData<Login>
        get() = _loginInfo

    fun getLogin(email: String, password: String) {
        viewModelScope.launch {
            val login = loginRepository.getLoginInfo(email, password).enqueue(object : Callback<Login> {
                override fun onResponse(
                    call: Call<Login>,
                    response: Response<Login>
                ) {
                    if (response.isSuccessful) {
                        _loginInfo.value = response.body()
                    } else {
                        Log.d("LoginViewModel", "Error: ${response.errorBody()}")
                    }
                }

                override fun onFailure(call: Call<Login>, t: Throwable) {
                    Log.d("LoginViewModel", "Error: ${t.toString()}")
                }

            })
        }
    }
}