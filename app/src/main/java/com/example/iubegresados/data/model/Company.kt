package com.example.iubegresados.data.model

import java.io.Serializable

data class Company(
    val name: String,
    val email: String,
    val address: String,
    val status: Boolean,
    val cellphone: Long,
    val website: String,
    val companyId: String,
    val nit: Long,
    val creationDate: String
) : Serializable {}