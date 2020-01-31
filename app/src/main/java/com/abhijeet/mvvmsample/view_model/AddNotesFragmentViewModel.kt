package com.abhijeet.mvvmsample.view_model

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.abhijeet.mvvmsample.App
import com.abhijeet.mvvmsample.model.localDB.dao.DataProvider
import com.abhijeet.mvvmsample.model.localDB.entity.Notes
import com.abhijeet.samplemvp.logger.log
import com.google.gson.Gson


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
            notesData =insertOrUpdateNotes(App.db?.databaseServiceDao()!!,notesData)

            notesMutable.postValue(notesData)

            log(TAG, "User Valid: ${Gson().toJson(notesData)}")


        }
        thread.start()
    }

    fun insertOrUpdateNotes(dataProvider: DataProvider,note: Notes):Notes{
        return if(note.id!=null&&note.id!! >0 ){
            dataProvider.updateNotes(note)
            notesData
        }else{
            dataProvider.getNotes(dataProvider.insertNotes(note))
        }
    }

    override fun onCleared() {
        super.onCleared()
        notesMutable.removeObserver(observer)
        log(TAG, "onCleared() called! on AddNotesFragmentViewModel")
    }
}
