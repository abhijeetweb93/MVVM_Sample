package com.abhijeet.mvvmsample.base

import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.annotation.LayoutRes
import android.os.Bundle
import android.transition.Explode
import android.view.ViewGroup
import androidx.annotation.Nullable
import com.abhijeet.mvvmsample.R
import com.abhijeet.mvvmsample.databinding.ActivityBaseBinding
import com.abhijeet.samplemvp.logger.log
import com.google.android.material.navigation.NavigationView
import androidx.core.view.GravityCompat
import android.view.MenuItem
import androidx.drawerlayout.widget.DrawerLayout
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import android.transition.Fade
import android.transition.Slide
import android.view.Window


abstract class BaseActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private val TAG = BaseActivity::class.java.simpleName
    protected var baseBinding: ActivityBaseBinding? = null
    protected var mDrawerToggle: ActionBarDrawerToggle? = null

    var isShowDrawerToggle: Boolean = true
    var isEnableDrawer: Boolean = true


    override fun onCreate(@Nullable savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        with(window) {
            requestFeature(Window.FEATURE_CONTENT_TRANSITIONS)
            // set an exit transition
            exitTransition = Explode()
        }

        baseBinding = DataBindingUtil.setContentView(this, R.layout.activity_base)
        log(TAG, "onCreate() execute")

    }

    private fun setupWindowAnimations() {
        val fade = Fade()
        fade.setDuration(2000)
        window.enterTransition = fade

        val slide = Slide()
        slide.setDuration(2000)
        window.returnTransition = slide
    }

    protected fun <T : ViewDataBinding> putContentView(@LayoutRes resId: Int): T {
        val viewGroup: ViewGroup = baseBinding?.layoutContainer!!
        setupNavigation()
        setupWindowAnimations()
        return DataBindingUtil.inflate(layoutInflater, resId, viewGroup, true)
    }

    protected fun <T : ViewDataBinding> putContentView(
        @LayoutRes resId: Int, isShowDrawerToggle: Boolean,
        isEnableDrawer: Boolean
    ): T {
        this.isEnableDrawer = isEnableDrawer
        this.isShowDrawerToggle = isShowDrawerToggle
        return putContentView(resId)
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

    private fun setupNavigation() {

        setSupportActionBar(baseBinding?.toolbarBase)
        supportActionBar!!.setDisplayHomeAsUpEnabled(isShowDrawerToggle)
        supportActionBar!!.setDisplayShowHomeEnabled(isShowDrawerToggle)

        mDrawerToggle = object : ActionBarDrawerToggle(
            this,
            baseBinding?.drawerLayoutBase,
            baseBinding?.toolbarBase,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        ) {

            override fun onDrawerSlide(drawerView: View, slideOffset: Float) {
                super.onDrawerSlide(drawerView, slideOffset)
                baseBinding?.toolbarBase?.alpha = 1 - slideOffset / 2
            }

            override fun onDrawerClosed(drawerView: View) {
                super.onDrawerClosed(drawerView)
            }

            override fun onDrawerOpened(drawerView: View) {
                super.onDrawerOpened(drawerView)
            }
        }

        baseBinding?.drawerLayoutBase!!.setDrawerListener(mDrawerToggle)
        baseBinding?.drawerLayoutBase!!.post { mDrawerToggle!!.syncState() }

        baseBinding?.navigationView?.setNavigationItemSelectedListener(this)

        mDrawerToggle?.isDrawerIndicatorEnabled = isShowDrawerToggle

        baseBinding?.drawerLayoutBase?.isEnabled = isEnableDrawer

        baseBinding?.drawerLayoutBase?.setDrawerLockMode(if (isEnableDrawer) DrawerLayout.LOCK_MODE_UNLOCKED else DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
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


    override fun onBackPressed() {
        if (baseBinding?.drawerLayoutBase?.isDrawerOpen(GravityCompat.START)!!) {
            baseBinding?.drawerLayoutBase?.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    fun enableDisableDrawer(mode: Int) {
        if (baseBinding?.drawerLayoutBase != null) {
            baseBinding?.drawerLayoutBase!!.setDrawerLockMode(mode)
        }
    }
}