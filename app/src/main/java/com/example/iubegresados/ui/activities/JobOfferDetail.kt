package com.example.iubegresados.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.marginBottom
import androidx.core.view.marginLeft
import androidx.core.view.marginRight
import androidx.core.view.marginTop
import androidx.recyclerview.widget.RecyclerView
import com.example.iubegresados.R
import com.example.iubegresados.adapters.ApplicantsAdapter
import com.example.iubegresados.data.model.AppSingleton
import com.example.iubegresados.data.model.JobOffer
import com.example.iubegresados.data.model.SessionManager
import com.example.iubegresados.ui.viewModels.ApplicantsViewModel
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
import com.google.android.material.floatingactionbutton.FloatingActionButton

class JobOfferDetail : AppCompatActivity() {
    private lateinit var jobOfferTitleText: TextView
    private lateinit var jobOfferLocation : TextView
    private lateinit var jobOfferWebsite: TextView
    private lateinit var jobOfferMail: TextView
    private lateinit var jobOfferSalary: TextView
    private lateinit var jobOfferDetailDescriptionText: TextView
    private lateinit var applicantStatusText: TextView
    private lateinit var recyclerView: RecyclerView
    private lateinit var applicantsContainer: LinearLayout
    private lateinit var floatingApplyButton: ExtendedFloatingActionButton
    private lateinit var applicantViewModel: ApplicantsViewModel
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
        applicantStatusText = findViewById(R.id.applicantStatusText)
        recyclerView = findViewById(R.id.applicantsRecycleView)
        applicantsContainer = findViewById(R.id.applicantsContainer)
        floatingApplyButton = findViewById(R.id.floatingApplyButton)
        applicantViewModel = ApplicantsViewModel(application)

        jobOfferTitleText.text = jobOffer?.name
        jobOfferLocation.text = jobOffer?.company?.address
        jobOfferWebsite.text = jobOffer?.company?.website
        jobOfferMail.text = jobOffer?.company?.email
        jobOfferSalary.text = jobOffer?.salary.toString()
        jobOfferDetailDescriptionText.text = jobOffer?.description + "\n\n" + jobOffer?.workday

        val user = SessionManager(this).fetchUser()
        if (user?.roles?.any { it.name == "Admin" } == true) {
            val layoutParams = applicantsContainer.layoutParams as ViewGroup.MarginLayoutParams
            applicantsContainer.visibility = LinearLayout.VISIBLE

            layoutParams.setMargins(applicantsContainer.marginLeft, applicantsContainer.marginTop, applicantsContainer.marginRight, 24)
            applicantsContainer.layoutParams = layoutParams
            floatingApplyButton.visibility = FloatingActionButton.GONE

            val adapter = jobOffer?.let { ApplicantsAdapter(it.applicants) }
            Log.d("JobOfferDetail", "Applicants: ${jobOffer?.applicants}")
            recyclerView.adapter = adapter
        }

        if (jobOffer != null) {
            if (jobOffer.applicants.any { it.userid == user?.userid }) {
                applicantStatusText.visibility = TextView.VISIBLE
                applicantStatusText.text = "Aplicando"
                floatingApplyButton.visibility = FloatingActionButton.GONE
            }
        }

        floatingApplyButton.setOnClickListener {
            applicantViewModel.applyJobOffer(jobOffer?.offerid.toString(), user?.userid.toString())

            applicantViewModel.applicantResponse.observe(this) { applicantResponse ->
                if (applicantResponse.resultado == "Aplicante creado") {
                    finish()
                } else {
                    Log.d("JobOfferDetail", "Error applying to job offer: ${applicantResponse.resultado}")
                    Toast.makeText(this, "Error applying to job offer", Toast.LENGTH_SHORT).show()
                }
            }
        }

    }
}