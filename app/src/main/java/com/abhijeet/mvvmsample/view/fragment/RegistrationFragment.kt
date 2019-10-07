package com.abhijeet.mvvmsample.view.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.abhijeet.mvvmsample.R
import com.abhijeet.mvvmsample.base.BaseFragment
import com.abhijeet.mvvmsample.databinding.FragmentLoginBinding
import com.abhijeet.mvvmsample.databinding.FragmentRegistrationBinding
import com.abhijeet.mvvmsample.view_model.RegistrationFragmentViewModel
import com.abhijeet.mvvmsample.view_model.SplashViewModel
import com.abhijeet.samplemvp.logger.log
import kotlinx.android.synthetic.main.fragment_registration.*

class RegistrationFragment : BaseFragment() {
    private val TAG = RegistrationFragment::class.java.simpleName

    lateinit var viewModel: RegistrationFragmentViewModel


    override fun onCreateView(inflater: LayoutInflater,  container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val binding: FragmentRegistrationBinding = DataBindingUtil.inflate( inflater, R.layout.fragment_registration, container, false)

        binding?.setLifecycleOwner(this)
        viewModel = ViewModelProviders.of(this).get(RegistrationFragmentViewModel::class.java!!)

        binding.viewModel=viewModel

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnSignup.setOnClickListener {
            log(TAG,viewModel.toString())
        }
    }

    override fun getLayoutResId(): Int {
        return R.layout.fragment_registration
    }

    override fun initView() {
    }

    override fun initData() {
    }

}