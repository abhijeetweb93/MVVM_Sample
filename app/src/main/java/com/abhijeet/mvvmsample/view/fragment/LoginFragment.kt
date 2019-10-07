package com.abhijeet.mvvmsample.view.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.abhijeet.mvvmsample.R
import com.abhijeet.mvvmsample.base.BaseFragment
import com.abhijeet.mvvmsample.databinding.FragmentLoginBinding
import com.abhijeet.mvvmsample.view.activity.LoginRegisterActivity
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : BaseFragment() {
    private val TAG = LoginFragment::class.java.simpleName

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View? {
        val binding:FragmentLoginBinding= DataBindingUtil.inflate( inflater, R.layout.fragment_login, container, false)

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tvLinkSignup.setOnClickListener {
            findNavController().navigate(R.id.registrationFragment)
        }

    }

    override fun getLayoutResId(): Int {
        return R.layout.fragment_login
    }

    override fun initView() {
    }

    override fun initData() {
    }
}