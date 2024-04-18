package com.example.iubegresados.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.iubegresados.R
import com.example.iubegresados.data.model.SessionManager
import com.example.iubegresados.ui.viewModels.UserViewModel


class UserFragment : Fragment() {

    private lateinit var userViewModel: UserViewModel
    private lateinit var sessionManager: SessionManager

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        val userid = sessionManager.fetchUser()?.userid

        // Verifica que el userid no sea nulo antes de llamar a getUserBy()
        if (!userid.isNullOrEmpty()) {
            userViewModel.getUserBy(userid)
            userViewModel.userInfo.observe(viewLifecycleOwner) { userInfo ->
                Log.d("UserFragment", "Usuario: $userInfo")
            }
        } else {
            Log.e("UserFragment", "No se pudo obtener el userid")
        }

        userViewModel.getUserBy("")
        userViewModel.userInfo.observe(viewLifecycleOwner) { userInfo ->
            Log.d("HomeFragment", "Usuario: $userInfo")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user, container, false)
    }

}