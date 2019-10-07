package com.abhijeet.mvvmsample.base

import com.abhijeet.mvvmsample.model.data_model.DataResponse

open class BaseRepository {

    suspend fun <T : Any> apiCall(call: suspend () -> DataResponse<T>): DataResponse<T> {
        return call.invoke()
    }

}