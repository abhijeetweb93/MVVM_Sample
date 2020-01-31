package com.abhijeet.mvvmsample.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.abhijeet.mvvmsample.R
import com.abhijeet.mvvmsample.base.BaseFragment
import com.abhijeet.mvvmsample.databinding.FragmentHomeListBinding
import com.abhijeet.mvvmsample.view_model.HomeNotesListFragmentViewModel
import com.abhijeet.samplemvp.logger.log
import com.google.gson.Gson


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


        viewModel.getSelected().observe(this, Observer {
            log(TAG,"observe list ${Gson().toJson(it)}")
            val bundle = Bundle()
            bundle.putSerializable("NOTES", Gson().toJson(it))
            activity?.findNavController(R.id.nav_host_fragment_home)?.navigate(R.id.homeAddNotes,bundle)
        })

    }
}