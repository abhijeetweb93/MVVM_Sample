package com.abhijeet.mvvmsample.view.activity

import android.os.Bundle
import com.abhijeet.mvvmsample.R
import com.abhijeet.mvvmsample.base.BaseActivity
import com.abhijeet.mvvmsample.databinding.ActivityHomeBinding

class HomeActivity : BaseActivity() {

    var binding: ActivityHomeBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        binding = putContentView(R.layout.activity_home, true, true)

        //        toolbarBase.setNavigationIcon(android.R.drawable.arrow_down_float)
//        toolbarBase.setNavigationOnClickListener {
//            onBackPressed()
//        }
    }
}
