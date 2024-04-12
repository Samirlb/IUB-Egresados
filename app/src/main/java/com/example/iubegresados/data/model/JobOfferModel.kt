package com.example.iubegresados.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "job_offers")
data class JobOfferModel(
    @PrimaryKey
    @ColumnInfo(name = "offerid")
    val offerid: String,

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "workday")
    val workday: String,

    @ColumnInfo(name = "status")
    val status: Boolean,

    @ColumnInfo(name = "creationdate")
    val creationdate: String,

    @ColumnInfo(name = "companyid")
    val companyid: String
)
