//package com.example.iubegresados.ui.viewModels
//
//import android.app.Application
//import androidx.lifecycle.AndroidViewModel
//import androidx.lifecycle.LiveData
//import androidx.lifecycle.MutableLiveData
//import androidx.lifecycle.viewModelScope
//import com.example.iubegresados.data.model.User
//import com.example.iubegresados.data.model.UserModel
//import com.example.iubegresados.data.repository.UserRepository
//import kotlinx.coroutines.launch
//
//class UserViewModel(application: Application): AndroidViewModel(application) {
//
//    private val userRepository = UserRepository(application)
//
//    private val _loginResult = MutableLiveData<Boolean>()
//    val loginResult: LiveData<Boolean>
//        get() = _loginResult
//
//    private val _userSaved = MutableLiveData<User>()
//    val userSaved: LiveData<User>
//        get() = _userSaved
//
//    private val _userUpdate = MutableLiveData<User>()
//    val userUpdate: LiveData<User>
//        get() = _userUpdate
//
//    private val _userList = MutableLiveData<List<UserModel>>()
//    val userList: LiveData<List<UserModel>>
//        get() = _userList
//
////    fun validateLogin(email: String, password: String) {
////        viewModelScope.launch {
////            val isValidLogin = userRepository.validateLogin(email, password)
////            _loginResult.value = isValidLogin
////        }
////    }
////
////    fun saveUser(user: User) {
////        viewModelScope.launch {
////            val userModel = UserModel(user.getId(), user.getEmail(), user.getPassword(), user.getName(), user.getPhoneNumber())
////            userRepository.setUsers(userModel)
////            _userSaved.value = user
////        }
////    }
////
////    fun updateUser(user: User) {
////        viewModelScope.launch {
////            val userModel = UserModel(user.getId(), user.getEmail(), user.getPassword(), user.getName(), user.getPhoneNumber())
////            userRepository.updateUser(userModel)
////            _userUpdate.value = user
////        }
////    }
////
////    fun getUserFrom(email: String, password: String) {
////        viewModelScope.launch {
////            val userModel = userRepository.getUserFrom(email, password)
////            if (userModel != null) {
////                _userSaved.value = User(userModel)
////            }
////        }
////    }
////
////    fun getUsers() {
////        viewModelScope.launch {
////            _userList.value = userRepository.getUsers()
////        }
////    }
//}