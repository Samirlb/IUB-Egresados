package com.example.iubegresados.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.iubegresados.R
import com.example.iubegresados.adapters.JobOfferAdapter
import com.example.iubegresados.ui.viewModels.JobOfferViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeFragment : Fragment() {
    private lateinit var jobOfferViewModel: JobOfferViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        jobOfferViewModel = ViewModelProvider(this).get(JobOfferViewModel::class.java)
        jobOfferViewModel.getJobOffers()

        jobOfferViewModel.jobOffers.observe(this) { jobOffers ->
            val adapter = JobOfferAdapter(jobOffers, jobOfferViewModel)
//            recyclerView.adapter = adapter
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }
}