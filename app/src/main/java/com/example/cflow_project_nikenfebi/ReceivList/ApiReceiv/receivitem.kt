package com.example.cflow_project_nikenfebi.ReceivList.ApiReceiv

data class receivitem (
    val id: String,
    val nama: String,
    val nominal: Int,
    val done_at: String? = null,
    val created_at: String
)