package com.abhijeet.mvvmsample.model.data_model

data class AppCredentials(
    var userID: Int? = null,
    var userName: String? = null,
    var isUserLoggedIn: Boolean = false
)