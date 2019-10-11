package com.abhijeet.mvvmsample.view_model

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.abhijeet.mvvmsample.R
import com.abhijeet.mvvmsample.model.data_model.LoginInfo
import com.abhijeet.samplemvp.logger.log


class LoginFragmentViewModel : ViewModel() {
    private val TAG = LoginFragmentViewModel::class.java.simpleName

    var loginInfo = MutableLiveData<LoginInfo>()



    fun onClickLogInButton(view: View) {
        log(TAG, "Log In Clicked")
    }

    fun onClickTvLinkSignup(view: View) {
        view.findNavController().navigate(R.id.registrationFragment)
    }

    override fun onCleared() {
        super.onCleared()
        log(TAG, "onCleared() called!")
    }
}
