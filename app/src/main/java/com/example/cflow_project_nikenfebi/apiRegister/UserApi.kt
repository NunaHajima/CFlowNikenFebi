package com.example.cflow_project_nikenfebi.apiRegister

import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface UserApi {
    @POST ("/auth/v1/signup")
    suspend fun daftar(
        @Header ("Authorization") token: String,
        @Header ("apikey") apiKey: String,
        @Body data: Users
    ) : Response<ResponseBody>

    @POST("/auth/v1/token?grant_type=password")
    suspend fun masuk(
        @Header("Authorization") token: String,
        @Header("apikey") apiKey: String,
        @Body data : Users
    ) : Response<ResponseBody>
}