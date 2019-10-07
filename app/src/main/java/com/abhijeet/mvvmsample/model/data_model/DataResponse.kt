package com.abhijeet.mvvmsample.model.data_model

data class DataResponse<out T>(val errorCode: Int, val errorMsg: String, val data: T)