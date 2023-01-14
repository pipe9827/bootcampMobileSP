package com.example.finalproyect2.repository


import com.example.finalproyect2.Model.DocumentRequest
import com.example.finalproyect2.network.DocumentsApi
import com.example.finalproyect2.responses.DocumentResponse
import com.example.finalproyect2.responses.LoginResponse
import javax.inject.Inject

class DocumentsRepository @Inject constructor (
    private val api: DocumentsApi
):BaseRepository() {
    suspend fun getDocuments(
        email:String
    ) : DocumentResponse {
        return api.getDocuments(email)
    }

    suspend fun saveDocument(
        documentRequest: DocumentRequest
    ){
        api.saveDocument(documentRequest)
    }
}