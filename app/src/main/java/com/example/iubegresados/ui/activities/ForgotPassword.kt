package com.example.iubegresados.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.iubegresados.R

class ForgotPassword : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)

        BarToolbar().show(this, true)
    }
}