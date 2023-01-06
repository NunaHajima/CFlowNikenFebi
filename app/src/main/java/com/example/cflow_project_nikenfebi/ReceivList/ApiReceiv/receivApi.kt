package com.example.cflow_project_nikenfebi.ReceivList.ApiReceiv

import retrofit2.Response
import retrofit2.http.*

interface receivApi {
    @GET("/rest/v1/Receivable?select=*")
    suspend fun get3(
        @Header("Authorization") token: String,
        @Header("apikey") apiKey: String
    ) : Response<List<receivitem>>

    @POST("/rest/v1/Receivable")
    suspend fun create3(
        @Header("Authorization") token: String,
        @Header("apikey") apiKey: String,
        @Body receivData: receivdata
    )

    @PATCH("/rest/v1/Receivable")
    suspend fun update3(
        @Header("Authorization") token: String,
        @Header("apikey") apiKey: String,
        @Query("id") idQuery : String,
        @Body receivData: receivdata
    ) : Response<Unit>

    @DELETE("/rest/v1/Receivable")
    suspend fun delete3(
        @Header("Authorization") token: String,
        @Header("apikey") apiKey: String,
        @Query("id") idQuery : String
    ) : Response<Unit>
}