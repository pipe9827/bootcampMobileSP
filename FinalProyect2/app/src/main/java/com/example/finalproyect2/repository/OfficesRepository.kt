package com.example.finalproyect2.repository

import com.example.finalproyect2.network.AuthApi
import com.example.finalproyect2.network.OfficesApi
import com.example.finalproyect2.responses.LoginResponse
import com.example.finalproyect2.responses.OfficesResponse
import javax.inject.Inject

class OfficesRepository @Inject constructor(
    private val api: OfficesApi
    ):BaseRepository() {
        suspend fun offices(

        ) : OfficesResponse {
            return api.offices()
        }
}