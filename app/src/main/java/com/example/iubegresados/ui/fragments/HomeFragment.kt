package com.example.iubegresados.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.iubegresados.R
import com.example.iubegresados.adapters.ApplicantsAdapter
import com.example.iubegresados.adapters.JobOfferAdapter
import com.example.iubegresados.data.model.AppSingleton
import com.example.iubegresados.ui.viewModels.CompanyViewModel
import com.example.iubegresados.ui.viewModels.JobOfferViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeFragment : Fragment() {
    private lateinit var jobOfferViewModel: JobOfferViewModel
    private lateinit var recyclerView: RecyclerView
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.jobOfferRecycler)
        jobOfferViewModel = ViewModelProvider(this).get(JobOfferViewModel::class.java)

        jobOfferViewModel.getJobOffers()

        jobOfferViewModel.jobOffers.observe(viewLifecycleOwner) { jobOffers ->
            Log.d("HomeFragment", "Ofertas de trabajo: $jobOffers")
            val adapter = JobOfferAdapter(jobOffers, jobOfferViewModel)
            recyclerView.adapter = adapter
        }
    }

    override fun onResume() {
        super.onResume()
        jobOfferViewModel.getJobOffers()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }
}