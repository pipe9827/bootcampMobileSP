package com.example.finalproyect2.repository

import com.example.finalproyect2.network.Resource
import com.google.android.gms.common.api.internal.TaskApiCall
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException

abstract class BaseRepository {


    suspend fun <T> safeApiCall(
        apiCall: suspend ()-> T
    ):Resource<T>{
        return withContext(Dispatchers.IO){
            try {
                Resource.Success(apiCall.invoke())
            }catch (throwable:Throwable){
                when(throwable){
                    is HttpException ->{
                        Resource.Failure(false,throwable.code(),throwable.response()?.errorBody())
                    }
                    else->{
                        Resource.Failure(true,null,null)
                    }
                }
            }
        }
    }
}