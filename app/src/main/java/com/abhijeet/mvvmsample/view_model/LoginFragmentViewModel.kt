package com.abhijeet.mvvmsample.view_model

import android.content.Intent
import android.view.View
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.abhijeet.mvvmsample.App
import com.abhijeet.mvvmsample.R
import com.abhijeet.mvvmsample.model.data_model.LoginInfo
import com.abhijeet.mvvmsample.model.localDB.entity.Employee
import com.abhijeet.mvvmsample.view.activity.HomeActivity
import com.abhijeet.samplemvp.logger.log
import com.google.gson.Gson


class LoginFragmentViewModel() : ViewModel() {
    private val TAG = LoginFragmentViewModel::class.java.simpleName

    val observer = Observer<LoginInfo> {
    }


    var loginInfoMutable = MutableLiveData<LoginInfo>()

    fun getLoginInfo(): LiveData<LoginInfo> {
        return loginInfoMutable
    }

    var loginInfoData: LoginInfo = LoginInfo()

    fun onClickLogInButton(view: View) {
        log(TAG, "Log In Clicked")

        val thread = Thread {
            //fetch Records
            val isValid: Employee? = App.db?.databaseServiceDao()?.isUserValid(loginInfoData.name, loginInfoData.password)
            log(TAG, "User Info: ${Gson().toJson(isValid)}")

            if (isValid!=null&&isValid.id!! >0) {
                loginInfoMutable.postValue(loginInfoData)
            }

        }
        thread.start()
    }

    fun onClickTvLinkSignup(view: View) {
        view.findNavController().navigate(R.id.registrationFragment)
    }

    override fun onCleared() {
        super.onCleared()
        loginInfoMutable.removeObserver(observer)
        log(TAG, "onCleared() called!")
    }
}
