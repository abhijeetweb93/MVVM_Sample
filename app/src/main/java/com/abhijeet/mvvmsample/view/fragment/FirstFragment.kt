package com.abhijeet.mvvmsample.view.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.abhijeet.mvvmsample.R
import com.abhijeet.mvvmsample.base.BaseFragment

class FirstFragment : BaseFragment() {
    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_first, container, false);

    }
}