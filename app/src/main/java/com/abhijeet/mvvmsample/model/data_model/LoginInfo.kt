package com.abhijeet.mvvmsample.model.data_model

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable

data class LoginInfo(val name:String,val password:String): BaseObservable(){
    var userName: String? = name
        @Bindable get() = field
        set(userName) {
            field = userName
            //notifyPropertyChanged(BR.userName)
        }
    var userPassWord: String? = null
        @Bindable get() = field
        set(userPassWord) {
            field = userPassWord
            //notifyPropertyChanged(BR.userPassWord)
        }
}