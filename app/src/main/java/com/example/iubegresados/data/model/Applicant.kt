package com.example.iubegresados.data.model

import java.io.Serializable

data class Applicant(
    val applicantid: String,
    val offerid: String,
    val userid: String,
    val name: String,
    val role: String
) : Serializable {}
