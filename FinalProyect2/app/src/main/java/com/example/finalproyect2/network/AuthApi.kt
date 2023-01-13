package com.example.finalproyect2.network

import com.example.finalproyect2.responses.LoginResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface AuthApi {


    @GET("RS_Usuarios")
     suspend fun login(
        @Query("idUsuario") email:String,
        @Query("clave") password:String

    ) : LoginResponse
}