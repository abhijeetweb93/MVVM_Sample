package com.abhijeet.mvvmsample.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.abhijeet.mvvmsample.model.localDB.entity.Employee

class RegistrationFragmentViewModel() : ViewModel() {
    private val TAG = RegistrationFragmentViewModel::class.java.simpleName
    val employee = MutableLiveData<Employee>()

    fun getEmployee(): LiveData<Employee> {
        return employee
    }



}