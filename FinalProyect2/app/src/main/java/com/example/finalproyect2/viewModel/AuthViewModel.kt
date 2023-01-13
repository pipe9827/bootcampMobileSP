package com.example.finalproyect2.viewModel

import android.provider.ContactsContract.CommonDataKinds.Email
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.finalproyect2.network.Resource
import com.example.finalproyect2.repository.AuthRepository
import com.example.finalproyect2.responses.LoginResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor (
    private val repository: AuthRepository
) : ViewModel() {
    private val _loginResponse : MutableLiveData<LoginResponse> = MutableLiveData()
     val loginResponse:LiveData<LoginResponse>
     get() = _loginResponse


    fun login(
        email: String,
        password: String
    ) = viewModelScope.launch {
        try {
        _loginResponse.value = withContext(Dispatchers.IO) {
                repository.login(email, password)
            }!!
        }catch (e: Exception) {
            Log.d("PUTO EL QUE LO LEA", "${e.message}")
        }
    }
}