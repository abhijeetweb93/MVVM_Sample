package com.abhijeet.mvvmsample.view_model

import android.app.Activity
import androidx.lifecycle.ViewModel
import com.abhijeet.samplemvp.logger.log
import android.content.Intent
import android.os.Handler
import com.abhijeet.mvvmsample.view.activity.LoginRegisterActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.LiveData
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.os.CountDownTimer
import com.abhijeet.mvvmsample.App
import com.abhijeet.mvvmsample.base.BaseActivity
import com.abhijeet.mvvmsample.view.activity.HomeActivity
import java.util.*
import kotlin.reflect.KClass


class SplashViewModel : ViewModel() {
    private val TAG = SplashViewModel::class.java.simpleName

    val showCount = MutableLiveData<Int>()
    val navigationActivity = MutableLiveData<BaseActivity>()

    fun getCount(): LiveData<Int> {
        return showCount
    }

    init {
        log(TAG, "$TAG created!")
    }


    fun getNavigationTargetClass(): LiveData<BaseActivity>? {
        return navigationActivity
    }



    fun getNavigation(){
        //For 5 seconds
        val timer = object: CountDownTimer(5*1000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                log(TAG, "CountDownTimer onTick $millisUntilFinished ")
                showCount.postValue((millisUntilFinished/1000).toInt())
            }

            override fun onFinish() {
                showCount.value=0

                if(App().getCredentials().isUserLoggedIn){
                    navigationActivity.value=HomeActivity()
                }else{
                    navigationActivity.value=LoginRegisterActivity()
                }

                log(TAG, "CountDownTimer onFinish ")
            }
        }
        timer.start()
    }

//    fun getActivity(): LiveData<BaseActivity> {
//        return MutableLiveData<BaseActivity>().apply { value = LoginRegisterActivity() }
//    }


    override fun onCleared() {
        super.onCleared()
        log(TAG, "onCleared Called")
    }
}