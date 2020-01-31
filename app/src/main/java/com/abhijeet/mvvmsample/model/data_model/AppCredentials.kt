package com.abhijeet.mvvmsample.model.data_model

import com.abhijeet.mvvmsample.model.localDB.entity.Employee

data class AppCredentials(
    var isUserLoggedIn: Boolean = false,
    var employee: Employee = Employee()
)