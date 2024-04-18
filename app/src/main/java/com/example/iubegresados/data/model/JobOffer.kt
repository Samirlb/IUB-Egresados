package com.example.iubegresados.data.model

import java.io.Serializable

data class JobOffer(
    var offerid: String,
    var name: String,
    var workday: String,
    var status: Boolean,
    var salary: String,
    var description: String,
    var skills: String,
    var website: String,
    var creationdate: String,
    var companyid: String,
    var company: Company? = null
) : Serializable {
}
