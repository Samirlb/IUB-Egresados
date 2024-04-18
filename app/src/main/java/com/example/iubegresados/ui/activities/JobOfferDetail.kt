package com.example.iubegresados.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.iubegresados.R
import com.example.iubegresados.data.model.AppSingleton
import com.example.iubegresados.data.model.JobOffer

class JobOfferDetail : AppCompatActivity() {
    private lateinit var jobOfferTitleText: TextView
    private lateinit var jobOfferLocation : TextView
    private lateinit var jobOfferWebsite: TextView
    private lateinit var jobOfferMail: TextView
    private lateinit var jobOfferSalary: TextView
    private lateinit var jobOfferDetailDescriptionText: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_job_offer_detail)

        val jobOffer = AppSingleton.selectedJobOffer

        jobOfferTitleText = findViewById(R.id.jobOfferTitle)
        jobOfferLocation = findViewById(R.id.jobOfferLocationText)
        jobOfferWebsite = findViewById(R.id.jobOfferWebTextView)
        jobOfferMail = findViewById(R.id.jobOfferMailText)
        jobOfferSalary = findViewById(R.id.jobOfferSalaryText)
        jobOfferDetailDescriptionText = findViewById(R.id.jobOfferDetailDescriptionText)

        jobOfferTitleText.text = jobOffer?.name
        jobOfferLocation.text = jobOffer?.company?.address
        jobOfferWebsite.text = jobOffer?.company?.website
        jobOfferMail.text = jobOffer?.company?.email
        jobOfferSalary.text = jobOffer?.salary.toString()
        jobOfferDetailDescriptionText.text = jobOffer?.description + "\n\n" + jobOffer?.workday

    }
}