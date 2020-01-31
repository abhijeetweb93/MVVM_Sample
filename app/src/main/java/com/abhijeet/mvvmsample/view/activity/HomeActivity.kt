package com.abhijeet.mvvmsample.view.activity

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.abhijeet.mvvmsample.App
import com.abhijeet.mvvmsample.R
import com.abhijeet.mvvmsample.base.BaseActivity
import com.abhijeet.mvvmsample.databinding.ActivityHomeBinding
import com.abhijeet.mvvmsample.model.data_model.AppCredentials
import com.abhijeet.mvvmsample.model.localDB.entity.Employee
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


        getDrawerText()

        baseBinding?.navigationView!!.setNavigationItemSelectedListener(this)
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


            R.id.menuLoginLogout -> {
                var appCredentials: AppCredentials = App().getCredentials()
                appCredentials.isUserLoggedIn = false
                appCredentials.employee= Employee()

                App().setCredentials(appCredentials)

                val i = Intent(this, LoginRegisterActivity::class.java)
                i.addFlags(
                    Intent.FLAG_ACTIVITY_CLEAR_TOP or
                            Intent.FLAG_ACTIVITY_CLEAR_TASK or
                            Intent.FLAG_ACTIVITY_NEW_TASK
                )
                startActivity(i)
            }

        }
        return true
    }


    fun getDrawerText() {

        val headerView: View = baseBinding?.navigationView!!.getHeaderView(0)
        (headerView.findViewById(R.id.tvUserName) as TextView).text =
            App().getCredentials().employee.name
        (headerView.findViewById(R.id.tvEmail) as TextView).text =
            App().getCredentials().employee.email_id

        val menu: Menu = baseBinding?.navigationView!!.getMenu()

        //menu.findItem(R.id.menuLoginLogout).seton
    }
}
