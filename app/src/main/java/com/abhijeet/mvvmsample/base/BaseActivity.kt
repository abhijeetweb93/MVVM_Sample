package com.abhijeet.mvvmsample.base

import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.annotation.LayoutRes
import android.os.Bundle
import android.view.ViewGroup
import androidx.annotation.Nullable
import com.abhijeet.mvvmsample.R
import com.abhijeet.mvvmsample.databinding.ActivityBaseBinding
import com.abhijeet.samplemvp.logger.log
import androidx.navigation.ui.NavigationUI
import androidx.navigation.Navigation
import androidx.navigation.NavController
import com.google.android.material.navigation.NavigationView
import androidx.core.view.GravityCompat
import android.view.MenuItem


open abstract class BaseActivity : AppCompatActivity(),
    NavigationView.OnNavigationItemSelectedListener {

    private val TAG = BaseActivity::class.java.simpleName
    protected var baseBinding: ActivityBaseBinding? = null

    var navController: NavController? = null
    var navigationView: NavigationView? = null

    override fun onCreate(@Nullable savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        baseBinding = DataBindingUtil.setContentView(this, R.layout.activity_base)
        log(TAG, "onCreate() execute")
        setupNavigation()
    }


    protected fun <T : ViewDataBinding> putContentView(@LayoutRes resId: Int): T {
        val viewGroup: ViewGroup = baseBinding?.layoutContainer!!
        return DataBindingUtil.inflate(layoutInflater, resId, viewGroup, true)
    }


    override fun onDestroy() {
        super.onDestroy()
        log(TAG, "onDestroy() execute")
    }

    fun showProgressBar() {
        baseBinding?.progressBar?.visibility = VISIBLE
    }

    fun hideProgressBar() {
        baseBinding?.progressBar?.visibility = INVISIBLE
    }


    fun setupNavigation() {

        //toolbar = findViewById(R.id.toolbar)
        //setSupportActionBar(baseBinding?.toolbarBase)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)

        //drawerLayout = findViewById(R.id.drawer_layout)

        //navigationView = findViewById(R.id.navigationView)

        navController = Navigation.findNavController(this, R.id.nav_host_fragment)

        NavigationUI.setupActionBarWithNavController(
            this,
            navController!!,
            baseBinding?.drawerLayoutBase
        )

        NavigationUI.setupWithNavController(baseBinding?.navigationView!!, navController!!)


        navigationView?.setNavigationItemSelectedListener(this)

    }

//    override fun onSupportNavigateUp(): Boolean {
//        return NavigationUI.navigateUp(
//            baseBinding?.drawerLayoutBase,
//            Navigation.findNavController(this, R.id.nav_host_fragment)
//        )
//    }

    override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {

        menuItem.setChecked(true)

        baseBinding?.drawerLayoutBase?.closeDrawers()

        val id = menuItem.getItemId()

        when (id) {
            R.id.first -> navController?.navigate(R.id.firstFragment)

            R.id.second -> navController?.navigate(R.id.secondFragment)
        }
        return true
    }


    override fun onBackPressed() {
        if (baseBinding?.drawerLayoutBase?.isDrawerOpen(GravityCompat.START)!!) {
            baseBinding?.drawerLayoutBase?.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}