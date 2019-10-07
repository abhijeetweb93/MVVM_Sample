package com.abhijeet.mvvmsample.view.activity

import android.os.Bundle
import android.view.MenuItem
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.abhijeet.mvvmsample.R
import com.abhijeet.mvvmsample.base.BaseActivity
import com.abhijeet.mvvmsample.databinding.ActivityLoginRegisterBinding
import com.abhijeet.samplemvp.logger.log
import com.google.android.material.navigation.NavigationView


class LoginRegisterActivity : BaseActivity(), NavigationView.OnNavigationItemSelectedListener {

    private val TAG = LoginRegisterActivity::class.java.simpleName

    var navController: NavController? = null
    //var navigationView: NavigationView? = null

    var binding: ActivityLoginRegisterBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = putContentView(R.layout.activity_login_register, false, false)


        navController = Navigation.findNavController(this, R.id.nav_host_fragment)

        NavigationUI.setupActionBarWithNavController(
            this,
            navController!!,
            baseBinding?.drawerLayoutBase
        )

        NavigationUI.setupWithNavController(baseBinding?.navigationView!!, navController!!)
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
