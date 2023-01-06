package com.example.cflow_project_nikenfebi.Transaction

data class ModelTransaction(
    val Id: String? =null,
    val icon: String? = null,
    val Customers: String?,
    val Date: String,
    val Nominal: Int,
    val Desc: String? = null,
    val Type: String
)