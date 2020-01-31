package com.abhijeet.mvvmsample.view.fragment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.abhijeet.mvvmsample.App
import com.abhijeet.mvvmsample.R
import com.abhijeet.mvvmsample.base.BaseFragment
import com.abhijeet.mvvmsample.databinding.FragmentLoginBinding
import com.abhijeet.mvvmsample.model.data_model.AppCredentials
import com.abhijeet.mvvmsample.view.activity.HomeActivity
import com.abhijeet.mvvmsample.view.activity.LoginRegisterActivity
import com.abhijeet.mvvmsample.view_model.LoginFragmentViewModel
import com.abhijeet.mvvmsample.view_model.SplashViewModel
import com.abhijeet.samplemvp.logger.log
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : BaseFragment() {
    private val TAG = LoginFragment::class.java.simpleName

    lateinit var viewModel: LoginFragmentViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View? {
        val binding:FragmentLoginBinding= DataBindingUtil.inflate( inflater, R.layout.fragment_login, container, false)
        viewModel = ViewModelProviders.of(this).get(LoginFragmentViewModel::class.java)
        binding.viewModel=viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getLoginInfo().observe(this, Observer {

            var appCredentials: AppCredentials = App().getCredentials()
            appCredentials.isUserLoggedIn = true
            appCredentials.employee=it

            App().setCredentials(appCredentials)

            log(TAG, "Login Successfully: "+App().getCredentials())

            val i = Intent(view.context, HomeActivity::class.java)
            i.addFlags(
                Intent.FLAG_ACTIVITY_CLEAR_TOP or
                        Intent.FLAG_ACTIVITY_CLEAR_TASK or
                        Intent.FLAG_ACTIVITY_NEW_TASK
            )
            view.context.startActivity(i)
        })
    }

    override fun getLayoutResId(): Int {
        return R.layout.fragment_login
    }

    override fun initView() {
    }

    override fun initData() {
    }
}