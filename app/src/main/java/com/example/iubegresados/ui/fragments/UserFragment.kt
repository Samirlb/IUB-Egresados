package com.example.iubegresados.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.iubegresados.R
import com.example.iubegresados.data.model.SessionManager
import com.example.iubegresados.ui.viewModels.UserViewModel
import java.text.SimpleDateFormat
import java.util.Locale


class UserFragment : Fragment() {

    private lateinit var userViewModel: UserViewModel
    private lateinit var sessionManager: SessionManager
    private lateinit var tvMail: TextView
    private lateinit var tvName: TextView
    private lateinit var tvPhone: TextView
    private lateinit var tvAddress: TextView
    private lateinit var tvRoles: TextView
    private lateinit var tvStartDay: TextView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sessionManager = SessionManager(view.context)

        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        tvMail = view.findViewById(R.id.tvemail)
        tvName = view.findViewById(R.id.tvName)
        tvPhone = view.findViewById(R.id.tvphone)
        tvAddress = view.findViewById(R.id.tvAddress)
        tvRoles = view.findViewById(R.id.tvRoles)
        tvStartDay = view.findViewById(R.id.tvCreationDate)

        val user = sessionManager.fetchUser()

        tvMail.text = user?.email
        tvName.text = "${user?.firstname} ${user?.lastname}"
        tvPhone.text = user?.cellphone
        tvAddress.text = user?.address
        tvRoles.text = user?.roles?.joinToString(" - ") { it.name }
        tvStartDay.text = formatDate(user?.creationdate)
    }

    private fun formatDate(dateString: String?): String {
        dateString?.let {
            val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
            val date = dateFormat.parse(it)
            val formattedDate = SimpleDateFormat("dd MMMM yyyy", Locale.getDefault()).format(date)
            return formattedDate
        }
        return ""
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user, container, false)
    }

}