package com.abhijeet.mvvmsample

import android.app.Application
import android.content.Context
import com.abhijeet.mvvmsample.model.localDB.AppDatabase

open class App : Application() {

    companion object {
        var mContext: Context? = null
        var db : AppDatabase?=null
    }

    override fun onCreate() {
        super.onCreate()
        mContext= getApplicationContext()
        getDatabase()
    }

    fun getContext():Context{
         if (mContext!=null){
             return mContext as Context;
        }else{
           return  getApplicationContext()
         }
    }

    fun getDatabase():AppDatabase{
        if(db==null){
            db = AppDatabase.getDatabase(getContext())
        }
        return db as AppDatabase
    }

}