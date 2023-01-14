package com.example.finalproyect2.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.finalproyect2.Model.DocumentRequest
import com.example.finalproyect2.repository.DocumentsRepository
import com.example.finalproyect2.repository.OfficesRepository
import com.example.finalproyect2.responses.DocumentResponse
import com.example.finalproyect2.responses.OfficesResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject


@HiltViewModel
class DocumentsViewModel @Inject constructor(
    private val repository: DocumentsRepository
) : ViewModel() {
    private val _documentResponse : MutableLiveData<DocumentResponse> = MutableLiveData()
    val documentResponse: LiveData<DocumentResponse>
        get() = _documentResponse


    fun getDocument(
        email: String
        ) = viewModelScope.launch {
        try {
            _documentResponse.value = withContext(Dispatchers.IO) {
                repository.getDocuments(email)
            }!!
        }catch (e: Exception) {
            Log.d("Important message", "${e.message}")
        }
    }

    fun saveDocument(
        documentRequest:DocumentRequest
    ) = viewModelScope.launch {
        try {
            withContext(Dispatchers.IO) {
                repository.saveDocument(documentRequest)
            }
        } catch (e: Exception) {
            Log.d("Important message", "${e.message}")
        }
    }
}