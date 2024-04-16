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
//            itemView.findViewById<TextView>(R.id.titleNoteText).text = jobOffer.title
//            val contentTextView = itemView.findViewById<TextView>(R.id.contentNoteText)
//            contentTextView.text = jobOffer.content
//
//            // Botón para editar la nota
//            itemView.findViewById<Button>(R.id.noteEdit).setOnClickListener { v ->
//                val intent = Intent(v.context, UpdateNoteActivity::class.java)
//                intent.putExtra("note_id", jobOffer.id)
//                v.context.startActivity(intent)
//            }
//
//            // Botón para eliminar la nota
//            itemView.findViewById<Button>(R.id.eliminar).setOnClickListener { v ->
//                jobOfferViewModel.deleteNote(jobOffer)
//            }

//            // Botón para aumentar el tamaño de la fuente del contenido de la nota
//            itemView.findViewById<Button>(R.id.aumentar).setOnClickListener {
//                contentTextView.textSize += 1
//            }
//
//            // Botón para reducir el tamaño de la fuente del contenido de la nota
//            itemView.findViewById<Button>(R.id.reducir).setOnClickListener {
//                contentTextView.textSize -= 1
//            }
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
