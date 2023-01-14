package com.example.finalproyect2.network

import com.example.finalproyect2.Model.DocumentRequest
import com.example.finalproyect2.responses.DocumentResponse
import com.example.finalproyect2.responses.LoginResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface DocumentsApi {
    @GET("RS_Documentos")
    suspend fun getDocuments(
        @Query("correo") correo:String

    ) : DocumentResponse

    @POST("RS_Documentos")
    suspend fun saveDocument(
        @Body documentRequest:DocumentRequest

    )


}