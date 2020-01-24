package com.abhijeet.mvvmsample.model.repository

import com.abhijeet.mvvmsample.base.BaseRepository
import com.abhijeet.mvvmsample.model.data_model.DataResponse
import com.abhijeet.mvvmsample.model.localDB.entity.Employee

class RegistrationFragmentRepo : BaseRepository() {

    suspend fun register(employee: Employee): DataResponse<Employee> {
        var result :DataResponse<Employee>?=null


        return result!!
    }
}