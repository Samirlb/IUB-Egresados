package com.example.iubegresados.data.model

import java.io.Serializable

data class Login (
    val access_token: String = "",
    val token_type: String = ""
) : Serializable {}