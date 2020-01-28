package com.abhijeet.mvvmsample.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.abhijeet.mvvmsample.R
import com.abhijeet.mvvmsample.base.BaseFragment
import com.abhijeet.mvvmsample.databinding.FragmentHomeListBinding
import com.abhijeet.mvvmsample.view_model.HomeNotesListFragmentViewModel
import com.abhijeet.samplemvp.logger.log


class HomeNotesListFragment : BaseFragment() {
    private val TAG = HomeNotesListFragment::class.java.simpleName

    lateinit var viewModel: HomeNotesListFragmentViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View? {
        val binding:FragmentHomeListBinding= DataBindingUtil.inflate( inflater, R.layout.fragment_home_list, container, false)
        viewModel = ViewModelProviders.of(this).get(HomeNotesListFragmentViewModel::class.java)
        binding.viewModel=viewModel
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
        viewModel.init()

        viewModel.getNotes().observe(this, Observer {
            log(TAG,"observe list")
            viewModel.getMyAdapter().setNotesListList(it)
        })



//        viewModel.getSelected().observe(this, Observer<Any?> { dogBreed ->
//            if (dogBreed != null) {
//                Toast.makeText(this@DogBreedsActivity,"You selected a " + dogBreed.getBreed(),      Toast.LENGTH_SHORT
//                ).show()
//            }
//        })
    }
}