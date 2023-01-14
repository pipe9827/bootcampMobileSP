package com.example.finalproyect2.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.finalproyect2.repository.OfficesRepository
import com.example.finalproyect2.responses.OfficesResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class OfficesViewModel @Inject constructor(
    private val repository: OfficesRepository
) : ViewModel() {
    private val _officeResponse : MutableLiveData<OfficesResponse> = MutableLiveData()
    val officeResponse: LiveData<OfficesResponse>
        get() = _officeResponse


    fun offices() = viewModelScope.launch {
        try {
            _officeResponse.value = withContext(Dispatchers.IO) {
                repository.offices()
            }!!
        }catch (e: Exception) {
            Log.d("Important message", "${e.message}")
        }
    }
}