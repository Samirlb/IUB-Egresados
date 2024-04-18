package com.example.iubegresados.data.model

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson

class SessionManager (context: Context) {
    private var prefs: SharedPreferences = context.getSharedPreferences("myPrefs", Context.MODE_PRIVATE)

    companion object {
        const val USER_TOKEN = "user_token"
        const val USER = "user"
    }

    fun saveAuthToken(token: String) {
        val editor = prefs.edit()
        editor.putString(USER_TOKEN, token)
        editor.apply()
    }

    fun fetchAuthToken(): String? {
        return prefs.getString(USER_TOKEN, null)
    }

    fun saveUser(user: String) {
        val editor = prefs.edit()
        editor.putString(USER, user)
        editor.apply()
    }

    fun fetchUser(): User? {
        val user = prefs.getString(USER, null)
        Gson().fromJson(user, User::class.java)?.let {
            return it
        }
        return null
    }
}