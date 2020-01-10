package com.abhijeet.mvvmsample.view_model

import android.util.JsonReader
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import androidx.room.Room
import com.abhijeet.mvvmsample.R
import com.abhijeet.mvvmsample.model.localDB.AppDatabase
import com.abhijeet.mvvmsample.model.localDB.entity.Employee
import com.abhijeet.samplemvp.logger.log
import com.google.gson.Gson
import org.json.JSONObject

class RegistrationFragmentViewModel() : ViewModel() {
    private val TAG = RegistrationFragmentViewModel::class.java.simpleName
    val employee = MutableLiveData<Employee>()

    var employeeData:Employee=Employee()

    fun getEmployee(): LiveData<Employee> {
        return employee
    }


    fun onClickCreateAccountButton(view: View) {
        employee.postValue(employeeData)
        log(TAG, "Create Accousdasnt Clicked"+Gson().toJson(employee.value))


        //val db = AppDatabase.invoke(view.context)
    }

    fun onClickAllReadyMemberLink(view: View) {
        view.findNavController().popBackStack(R.id.loginFragment,false)
//        view.findNavController().navigate(R.id.loginFragment)
    }
}