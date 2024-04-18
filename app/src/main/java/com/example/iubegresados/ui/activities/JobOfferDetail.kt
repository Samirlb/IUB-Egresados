package com.example.iubegresados.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.iubegresados.R
import com.example.iubegresados.data.model.AppSingleton
import com.example.iubegresados.data.model.JobOffer

class JobOfferDetail : AppCompatActivity() {
    private lateinit var jobOfferTitle: TextView
    private lateinit var jobOfferLocation : TextView
    private lateinit var jobOfferWebsite: TextView
    private lateinit var jobOfferMail: TextView
    private lateinit var jobOfferSalary: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_job_offer_detail)

        val jobOffer = AppSingleton.selectedJobOffer

        jobOfferTitle = findViewById(R.id.jobOfferTitleText)
        jobOfferLocation = findViewById(R.id.jobOfferLocationText)
        jobOfferWebsite = findViewById(R.id.jobOfferWebTextView)
        jobOfferMail = findViewById(R.id.jobOfferMailText)
        jobOfferSalary = findViewById(R.id.jobOfferSalaryText)



    }
}