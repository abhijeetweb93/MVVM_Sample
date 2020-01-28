package com.abhijeet.mvvmsample.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.abhijeet.mvvmsample.R
import com.abhijeet.mvvmsample.base.BaseFragment
import com.abhijeet.mvvmsample.databinding.FragmentAddNotesBinding
import com.abhijeet.mvvmsample.view_model.AddNotesFragmentViewModel
import com.abhijeet.samplemvp.logger.log

class AddNotesFragment : BaseFragment(){
    private val TAG = AddNotesFragment::class.java.simpleName

    lateinit var viewModel: AddNotesFragmentViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View? {
        val binding:FragmentAddNotesBinding= DataBindingUtil.inflate( inflater, R.layout.fragment_add_notes, container, false)
        viewModel = ViewModelProviders.of(this).get(AddNotesFragmentViewModel::class.java)
        binding.viewModel=viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun getLayoutResId(): Int {
        return R.layout.fragment_add_notes
    }

    override fun initView() {
        val onBackPressedCallback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                log(TAG,"Call back")
            }
        }
        requireActivity().getOnBackPressedDispatcher().addCallback(this, onBackPressedCallback)

    }

    override fun initData() {
    }

}