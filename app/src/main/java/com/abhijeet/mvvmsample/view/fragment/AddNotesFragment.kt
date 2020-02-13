package com.abhijeet.mvvmsample.view.fragment

import android.R.attr.key
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import com.abhijeet.mvvmsample.R
import com.abhijeet.mvvmsample.base.BaseFragment
import com.abhijeet.mvvmsample.databinding.FragmentAddNotesBinding
import com.abhijeet.mvvmsample.model.localDB.entity.Notes
import com.abhijeet.mvvmsample.view_model.AddNotesFragmentViewModel
import com.abhijeet.samplemvp.logger.log
import com.google.gson.Gson


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
        if (this.arguments != null&& this.arguments?.getSerializable("NOTES")!=null) {
            val myInt = this.arguments?.getSerializable("NOTES").toString()
            viewModel.notesData=Gson().fromJson(myInt,Notes::class.java)
        }
        super.onViewCreated(view, savedInstanceState)
    }

    override fun getLayoutResId(): Int {
        return R.layout.fragment_add_notes
    }

    override fun initView() {

    }

    override fun initData() {
    }


    override fun onDestroy() {
        super.onDestroy()
        activity?.findNavController(R.id.nav_host_fragment_home)?.popBackStack()
    }

}