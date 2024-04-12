package com.example.iubegresados.ui.activities

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.iubegresados.R
import com.example.iubegresados.adapters.JobOfferAdapter
import com.example.iubegresados.ui.viewModels.JobOfferViewModel


class Home : AppCompatActivity() {
    private lateinit var jobOfferViewModel: JobOfferViewModel
    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        jobOfferViewModel = ViewModelProvider(this).get(JobOfferViewModel::class.java)

        jobOfferViewModel.getJobOffers()

        jobOfferViewModel.jobOffers.observe(this) { jobOffers ->
            val adapter = JobOfferAdapter(jobOffers, jobOfferViewModel)
            recyclerView.adapter = adapter
        }



    }

    @SuppressLint("MissingSuperCall")
    override fun onBackPressed() {}
}