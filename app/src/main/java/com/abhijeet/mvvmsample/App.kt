package com.abhijeet.mvvmsample

import android.app.Application
import android.content.Context

open class App : Application() {

    companion object {
        var mContext: Context? = null;
    }

    override fun onCreate() {
        super.onCreate()
        mContext= getApplicationContext()
    }

    fun getContext():Context{
         if (mContext!=null){
             return mContext as Context;
        }else{
           return  getApplicationContext()
         }
    }

}