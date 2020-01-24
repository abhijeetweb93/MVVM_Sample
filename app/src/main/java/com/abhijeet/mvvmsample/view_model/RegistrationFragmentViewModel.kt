package com.abhijeet.mvvmsample.view_model

import android.app.Activity
import android.os.AsyncTask
import android.view.View
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import com.abhijeet.mvvmsample.App
import com.abhijeet.mvvmsample.R
import com.abhijeet.mvvmsample.model.localDB.AppDatabase
import com.abhijeet.mvvmsample.model.localDB.entity.Employee
import com.abhijeet.samplemvp.logger.log
import com.google.gson.Gson
import java.lang.ref.WeakReference


class RegistrationFragmentViewModel() : ViewModel() {
    private val TAG = RegistrationFragmentViewModel::class.java.simpleName
    val employeeMutable = MutableLiveData<Employee>()

    var employeeData: Employee = Employee()

    fun getEmployee(): LiveData<Employee> {
        return employeeMutable
    }


    fun onClickCreateAccountButton(view: View) {
        employeeMutable.postValue(employeeData)
        log(TAG, "Create Accousdasnt Clicked" + Gson().toJson(employeeMutable.value))

        val thread = Thread {
            //val db = AppDatabase.getDatabase(view.context)
            App.db?.databaseServiceDao()?.insertAll(employeeData)
            //fetch Records
            App.db?.databaseServiceDao()?.getAll()?.forEach()
            {
                log("Fetch Records", "Id:  : ${it.name} Name:  : ${it.email_id}")
            }
        }
        thread.start()
    }

    fun onClickAllReadyMemberLink(view: View) {
        view.findNavController().popBackStack(R.id.loginFragment, false)
//        view.findNavController().navigate(R.id.loginFragment)
    }


}