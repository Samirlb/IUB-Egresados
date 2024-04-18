package com.example.iubegresados.adapters

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.iubegresados.R
import com.example.iubegresados.data.model.JobOffer
import com.example.iubegresados.ui.viewModels.JobOfferViewModel

class JobOfferAdapter(private var jobOfferList: List<JobOffer>, private val jobViewModel: JobOfferViewModel) : RecyclerView.Adapter<JobOfferAdapter.JobOfferViewHolder>() {

    class JobOfferViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(jobOffer: JobOffer, jobOfferViewModel: JobOfferViewModel) {
            itemView.findViewById<TextView>(R.id.jobOfferTitleText).text = jobOffer.name
            itemView.findViewById<TextView>(R.id.jobOfferCompanyText).text = jobOffer.companyid
            itemView.findViewById<TextView>(R.id.jobOfferDescriptionText).text = jobOffer.workday
            itemView.findViewById<TextView>(R.id.jobOfferLocation).text = "Baranquilla, Atlántico"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JobOfferViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.job_offer, parent, false)
        return JobOfferViewHolder(view)
    }

    override fun getItemCount(): Int {
        return jobOfferList.size
    }

    override fun onBindViewHolder(holder: JobOfferViewHolder, position: Int) {
        val jobOffer = jobOfferList[position]
        holder.bind(jobOffer, jobViewModel)
    }

    // Método para actualizar la lista de notas
    @SuppressLint("NotifyDataSetChanged")
    fun updateList(newJobOfferList: List<JobOffer>) {
        jobOfferList = newJobOfferList
    }
}
