package com.example.cflow_project_nikenfebi.Member.Apimember

import java.util.jar.Attributes.Name

data class memberitem (
    val id: String,
    val Name: String,
    val TypeMember: String,
    val done_at: String? = null,
    val created_at: String
)