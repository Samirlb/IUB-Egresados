package com.example.iubegresados.data.model

import java.io.Serializable

data class User(
    var userid: String = "",
    var firstname: String = "",
    var lastname: String = "",
    var email: String = "",
    var cellphone: String = "",
    var address: String = "",
    var password: String = "",
    var status: Boolean = false,
    var creationdate: String = ""
) : Serializable {}

object AppSingleton {
    var user: User? = null
    var currentUser: User? = null
    var selectedJobOffer: JobOffer? = null
}
