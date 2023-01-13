package com.example.finalproyect2.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.finalproyect2.repository.AuthRepository
import com.example.finalproyect2.repository.BaseRepository
import com.example.finalproyect2.viewModel.AuthViewModel


class ViewModelFactory(
    private val repository: BaseRepository
) :ViewModelProvider.NewInstanceFactory(){

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when{
            modelClass.isAssignableFrom(AuthViewModel::class.java) -> AuthViewModel(repository as AuthRepository ) as T
            else -> throw IllegalArgumentException("View model class not found")
        }
    }
}