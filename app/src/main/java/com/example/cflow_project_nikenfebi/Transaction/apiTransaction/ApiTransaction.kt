package com.example.cflow_project_nikenfebi.Transaction.apiTransaction

import com.example.cflow_project_nikenfebi.CreateTransaction.CreateData
import retrofit2.Response
import retrofit2.http.*
import java.lang.reflect.Type

interface ApiTransaction{
    @GET("/rest/v1/Transaction?select=*")
    suspend fun get(
        @Header("Authorization") token : String,
        @Header("apikey") apiKey : String,
    ) : Response<List<TransactionItem>>

    @POST("/rest/v1/Transaction")
    suspend fun create(
        @Header("Authorization") token: String,
        @Header("apikey") apiKey: String,
        @Body createdata: CreateData
    )

    @PATCH("/rest/v1/Transaction")
    suspend fun update(
        @Header("Authorization") token: String,
        @Header("apikey") apiKey: String,
        @Query("id") idQuery : String,
        @Body createdata: CreateData
    ) : Response<Unit>

    @DELETE("/rest/v1/Transaction")
    suspend fun delete(
        @Header("Authorization") token: String,
        @Header("apikey") apiKey: String,
        @Query("id") idQuery : String
    ) : Response<Unit>
}