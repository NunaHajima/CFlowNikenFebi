package com.example.cflow_project_nikenfebi.Transaction.apiTransaction

data class TransactionItem (
    val id: String?=null,
    val Date : String,
    val Customers : String? = null,
    val Nominal : Int,
    val Description: String,
    val Type: String,
    val Done_at : String? = null,
    val Create_at : String
)