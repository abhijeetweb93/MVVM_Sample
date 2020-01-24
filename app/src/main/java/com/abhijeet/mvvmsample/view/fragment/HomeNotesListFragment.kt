package com.abhijeet.mvvmsample.view.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.abhijeet.mvvmsample.R
import com.abhijeet.mvvmsample.base.BaseFragment
import com.abhijeet.mvvmsample.databinding.FragmentHomeListBinding

class HomeNotesListFragment : BaseFragment() {
    private val TAG = HomeNotesListFragment::class.java.simpleName

    //lateinit var viewModel: LoginFragmentViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View? {
        val binding:FragmentHomeListBinding= DataBindingUtil.inflate( inflater, R.layout.fragment_home_list, container, false)
        //viewModel = ViewModelProviders.of(this).get(LoginFragmentViewModel::class.java)
        //binding.viewModel=viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun getLayoutResId(): Int {
        return R.layout.fragment_home_list
    }

    override fun initView() {
    }

    override fun initData() {
    }
}