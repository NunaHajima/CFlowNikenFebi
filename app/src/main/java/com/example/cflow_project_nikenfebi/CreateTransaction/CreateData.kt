package com.example.cflow_project_nikenfebi.CreateTransaction

data class CreateData(
    val Customers: String,
    val Date: String,
    val Nominal: Int,
    val Type: String,
    val Description: String?= null,
    val Done_at: String? = null
)