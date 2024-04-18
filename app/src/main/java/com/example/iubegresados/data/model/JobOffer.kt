package com.example.iubegresados.data.model

import java.io.Serializable

data class JobOffer(
    var offerid: String,
    var name: String,
    var workday: String,
    var status: Boolean,
    var creationdate: String,
    var companyid: String,
    var companyname: String = "",
    var companyaddress: String = ""
) : Serializable {
    constructor(jobOfferModel: JobOfferModel) : this(
        jobOfferModel.offerid,
        jobOfferModel.name,
        jobOfferModel.workday,
        jobOfferModel.status,
        jobOfferModel.creationdate,
        jobOfferModel.companyid
    )
}
