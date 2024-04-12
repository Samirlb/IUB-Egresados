//package com.example.iubegresados.data.repository
//
//import android.content.Context
//import com.example.iubegresados.data.db.AppDatabase
//import com.example.iubegresados.data.model.UserModel
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.withContext
//
//class UserRepository(context: Context) {
//
//    private val database = AppDatabase.getInstance(context)
//
//    suspend fun getUsers(): List<UserModel>{
//        return withContext(Dispatchers.IO){
//            database.userDao().getUsers()
//        }
//    }
//
//    suspend fun getUserById(uid: String): UserModel {
//        return withContext(Dispatchers.IO) {
//            database.userDao().getUserById(uid)
//        }
//    }
//    suspend fun update(user:UserModel) {
//        return withContext(Dispatchers.IO) {
//            database.userDao().update(user)
//        }
//    }
//
//    suspend fun saveNote(user:UserModel){
//        withContext(Dispatchers.IO){
//            database.userDao().insert(user)
//        }
//    }
//
//    suspend fun delete(user:UserModel) {
//        return withContext(Dispatchers.IO) {
//            database.userDao().delete(user)
//        }
//    }
//
//}