// MainActivity.kt
package com.example.iubegresados.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.iubegresados.R

class MainActivity : AppCompatActivity() {
    private lateinit var loginButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loginButton = findViewById(R.id.loginButton)

        loginButton.setOnClickListener {
            startActivity(Intent(this, Login::class.java))
        }
    }
}
