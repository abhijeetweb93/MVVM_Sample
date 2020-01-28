package com.abhijeet.mvvmsample.view.activity

import android.os.Bundle
import android.view.MenuItem
import androidx.activity.OnBackPressedCallback
import androidx.activity.addCallback
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.abhijeet.mvvmsample.R
import com.abhijeet.mvvmsample.base.BaseActivity
import com.abhijeet.mvvmsample.databinding.ActivityHomeBinding
import com.abhijeet.samplemvp.logger.log
import com.google.android.material.navigation.NavigationView

class HomeActivity : BaseActivity(), NavigationView.OnNavigationItemSelectedListener {
    private val TAG = HomeActivity::class.java.simpleName

    var binding: ActivityHomeBinding? = null
    private var navController: NavController? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = putContentView(R.layout.activity_home, true, true)

        navController = Navigation.findNavController(this, R.id.nav_host_fragment_home)

        NavigationUI.setupActionBarWithNavController(
            this,
            navController!!,
            baseBinding?.drawerLayoutBase
        )

        NavigationUI.setupWithNavController(baseBinding?.navigationView!!, navController!!)

//        toolbarBase.setNavigationIcon(android.R.drawable.arrow_down_float)
//        toolbarBase.setNavigationOnClickListener {
//            onBackPressed()
//        }
    }

    override fun onBackPressed() {
        if (navController?.popBackStack()!!) {
        } else
            super.onBackPressed()
    }


    override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {

        menuItem.setChecked(true)

        baseBinding?.drawerLayoutBase?.closeDrawers()

        val id = menuItem.getItemId()
        log(TAG, "Android ")

        when (id) {
//            R.id.first -> navController?.navigate(R.id.firstFragment)
//            R.id.second -> navController?.navigate(R.id.secondFragment)


            R.id.first -> {
                log(TAG, "Android ")
            }

        }
        return true
    }
}
