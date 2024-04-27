package com.example.iubegresados.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.iubegresados.R
import com.example.iubegresados.data.model.Applicant
import com.example.iubegresados.data.model.JobOffer

class ApplicantsAdapter(private var applicantsList: List<Applicant>) : RecyclerView.Adapter<ApplicantsAdapter.ApplicantsViewHolder>() {

    class ApplicantsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(applicant: Applicant) {
            itemView.findViewById<TextView>(R.id.applicantName).text = applicant.name
            itemView.findViewById<TextView>(R.id.applicantRole).text = applicant.role
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ApplicantsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.applicant, parent, false)
        return ApplicantsViewHolder(view)
    }


    override fun getItemCount(): Int {
        return applicantsList.size
    }

    override fun onBindViewHolder(holder: ApplicantsViewHolder, position: Int) {
        val applicant = applicantsList[position]
        holder.bind(applicant)
    }
}
