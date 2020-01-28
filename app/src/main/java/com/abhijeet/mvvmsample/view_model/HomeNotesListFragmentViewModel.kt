package com.abhijeet.mvvmsample.view_model

import android.content.Intent
import android.os.Handler
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import com.abhijeet.mvvmsample.App
import com.abhijeet.mvvmsample.R
import com.abhijeet.mvvmsample.model.data_model.LoginInfo
import com.abhijeet.mvvmsample.model.localDB.entity.Notes
import com.abhijeet.mvvmsample.view.activity.HomeActivity
import com.abhijeet.mvvmsample.view.adapter.HomeNotesListRVAdapter
import com.abhijeet.samplemvp.logger.log

class HomeNotesListFragmentViewModel : ViewModel() {
    private val TAG = HomeNotesListFragmentViewModel::class.java.simpleName
    val observer = Observer<List<Notes>> {
    }

    var loginInfoMutable = MutableLiveData<List<Notes>>()

    var loginInfoData: List<Notes> = mutableListOf()

    val adapter: HomeNotesListRVAdapter by lazy {
        HomeNotesListRVAdapter()
    }

    fun getNotes(): MutableLiveData<List<Notes>> {
        return loginInfoMutable
    }

    fun init() {

        val thread = Thread {
            //fetch Records
            loginInfoData = App.db?.databaseServiceDao()?.getAllNotes()!!

            loginInfoMutable.postValue(loginInfoData)

            log(TAG, "Notes Data: ${loginInfoData.toString()}")

            //adapter.setNotesListList(loginInfoData)
        }
        thread.start()

//        Handler().postDelayed(Runnable {
//            log(TAG, "Notes Data: ${loginInfoData.toString()}")
//            adapter.setNotesListList(loginInfoData)
//        }, 3000)



    }

    fun getMyAdapter(): HomeNotesListRVAdapter {
        return adapter
    }


    override fun onCleared() {
        super.onCleared()
        loginInfoMutable.removeObserver(observer)
        log(TAG, "onCleared() called!")
    }

    fun onClickAddButton(view: View) {
        view.findNavController().navigate(R.id.homeAddNotes)
    }
}