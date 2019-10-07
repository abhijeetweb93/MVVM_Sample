package com.abhijeet.mvvmsample.view.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.abhijeet.mvvmsample.R
import com.abhijeet.mvvmsample.base.BaseActivity
import com.abhijeet.mvvmsample.databinding.ActivitySplashBinding
import com.abhijeet.mvvmsample.view_model.SplashViewModel


class SplashActivity : BaseActivity() {
    var binding: ActivitySplashBinding? = null
    lateinit var viewModel: SplashViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        binding = putContentView(R.layout.activity_splash,false,false)

        //Hide App Bar Layout
        baseBinding?.appBarLayoutBase?.visibility= View.GONE

        binding?.setLifecycleOwner(this)
        viewModel = ViewModelProviders.of(this).get(SplashViewModel::class.java!!)

        viewModel.getNavigation()

        viewModel.getCount().observe(this, Observer {
            binding?.tv?.text=it.toString()
        })

        viewModel.getNavigationTargetClass()?.observe(this, Observer {
            //            val i = Intent(this, LoginRegisterActivity::class.java)
            val i = Intent(this, it::class.java)
            startActivity(i)

            finish()
        })


        showProgressBar()
    }


}
