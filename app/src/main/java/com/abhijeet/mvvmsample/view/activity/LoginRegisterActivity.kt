package com.abhijeet.mvvmsample.view.activity

import android.os.Bundle
import com.abhijeet.mvvmsample.R
import com.abhijeet.mvvmsample.base.BaseActivity
import com.abhijeet.mvvmsample.databinding.ActivityLoginRegisterBinding

class LoginRegisterActivity : BaseActivity() {

    var binding: ActivityLoginRegisterBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = putContentView(R.layout.activity_login_register)

        drawerVisibility(false)
        mDrawerToggle(false)

    }
}
