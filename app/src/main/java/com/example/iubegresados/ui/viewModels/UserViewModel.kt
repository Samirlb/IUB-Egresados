package com.example.iubegresados.ui.viewModels

import android.app.Application
import android.content.SharedPreferences
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.iubegresados.data.model.Login
import com.example.iubegresados.data.model.User
import com.example.iubegresados.data.repository.LoginRepository
import com.example.iubegresados.data.repository.UserRepository
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserViewModel(application: Application): AndroidViewModel(application) {
    private val userRepository = UserRepository(application)
    private val _userInfo = MutableLiveData<User>()
    val userInfo: MutableLiveData<User>
        get() = _userInfo

    fun getUserBy(id: String) {
        viewModelScope.launch {
            val user = userRepository.getUserById(id).enqueue(object : Callback<User> {
                override fun onResponse(
                    call: Call<User>,
                    response: Response<User>
                ) {
                    if (response.isSuccessful) {
                        _userInfo.value = response.body()
                    } else {
                        Log.d("UserViewModel", "Error: ${response.errorBody()}")
                    }
                }

                override fun onFailure(call: Call<User>, t: Throwable) {
                    Log.d("UserViewModel", "Fail: ${t.message.toString()}")
                }

            })
        }
    }
}