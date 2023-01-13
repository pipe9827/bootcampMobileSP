package com.example.finalproyect2.repository

import com.example.finalproyect2.network.AuthApi
import com.example.finalproyect2.responses.LoginResponse
import javax.inject.Inject

class AuthRepository @Inject constructor (
    private val api: AuthApi
        ):BaseRepository() {
            suspend fun login(
                email:String,
                password:String
            ) :LoginResponse{
              return api.login(email, password)
            }
}