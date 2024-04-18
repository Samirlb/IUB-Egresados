package com.example.iubegresados.data.model

import java.io.Serializable

data class User (
    var userid: String = "",
    var firstname: String = "",
    var lastname: String = "",
    var email: String = "",
    var cellphone: String = "",
    var address: String = "",
    var password: String = "",
    var status: Boolean = false,
    var roles: List<Role> = listOf(),
    var creationdate: String = ""
) : Serializable {}

