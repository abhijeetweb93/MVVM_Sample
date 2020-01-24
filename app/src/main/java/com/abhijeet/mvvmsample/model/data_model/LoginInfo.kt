package com.abhijeet.mvvmsample.model.data_model

data class LoginInfo(var name: String, var password: String) {
    constructor() : this("", "")
}