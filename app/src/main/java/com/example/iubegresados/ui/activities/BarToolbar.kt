package com.example.iubegresados.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.iubegresados.R

class BarToolbar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bar_toolbar)
    }

    fun show(activity: AppCompatActivity, upButton: Boolean) {
        activity.setSupportActionBar(activity.findViewById(R.id.toolbar))
        activity.supportActionBar?.setHomeAsUpIndicator(R.drawable.back);
        activity.supportActionBar?.title = ""
        activity.supportActionBar?.setDisplayHomeAsUpEnabled(upButton)
    }
}