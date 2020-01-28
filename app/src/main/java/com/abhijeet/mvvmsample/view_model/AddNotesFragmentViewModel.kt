package com.abhijeet.mvvmsample.view_model

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.abhijeet.mvvmsample.App
import com.abhijeet.mvvmsample.model.localDB.entity.Notes
import com.abhijeet.samplemvp.logger.log


class AddNotesFragmentViewModel() : ViewModel() {
    private val TAG = AddNotesFragmentViewModel::class.java.simpleName

    val observer = Observer<Notes> {
    }


    var notesMutable = MutableLiveData<Notes>()

    fun getNotes(): LiveData<Notes> {
        return notesMutable
    }

    var notesData: Notes = Notes()

    fun onClickSaveButton(view: View) {
        log(TAG, "Log In Clicked")
        val thread = Thread {
            //fetch Records
            notesMutable.postValue(notesData)

            val isValid: Unit? = App.db?.databaseServiceDao()?.insertNotes(notesData)

            log(TAG, "User Valid: $isValid")


        }
        thread.start()
    }


    override fun onCleared() {
        super.onCleared()
        notesMutable.removeObserver(observer)
        log(TAG, "onCleared() called!")
    }
}
