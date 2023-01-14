package com.example.finalproyect2.network


import com.example.finalproyect2.responses.OfficesResponse
import retrofit2.http.GET


interface OfficesApi {

    @GET("RS_Oficinas")
    suspend fun offices(

    ) : OfficesResponse
}