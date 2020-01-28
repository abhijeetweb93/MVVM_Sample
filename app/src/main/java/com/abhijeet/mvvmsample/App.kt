package com.abhijeet.mvvmsample

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.abhijeet.mvvmsample.model.data_model.AppCredentials
import com.abhijeet.mvvmsample.model.localDB.AppDatabase
import com.google.gson.Gson


open class App : Application() {

    companion object {
        var mContext: Context? = null
        var db: AppDatabase? = null
    }

    override fun onCreate() {
        super.onCreate()
        mContext = getApplicationContext()
        getDatabase()
    }

    fun getContext(): Context {
        if (mContext != null) {
            return mContext as Context;
        } else {
            return getApplicationContext()
        }
    }

    fun getDatabase(): AppDatabase {
        if (db == null) {
            db = AppDatabase.getDatabase(getContext())
        }
        return db as AppDatabase
    }

    fun getCredentials() :AppCredentials{
        val sharedPreferences: SharedPreferences = getContext().getSharedPreferences("MVVM", 0)
        return if(sharedPreferences.contains("AppCredentials")) Gson().fromJson(sharedPreferences.getString("AppCredentials", Gson().toJson(AppCredentials())), AppCredentials::class.java) else AppCredentials()
    }

    fun setCredentials(appCredentials: AppCredentials) {
        val sharedPreferences: SharedPreferences = getContext().getSharedPreferences("MVVM", 0)
        val sharedPreferencesEditor = sharedPreferences.edit()
        val serializedObject = Gson().toJson(appCredentials)
        sharedPreferencesEditor.putString("AppCredentials", serializedObject)
        sharedPreferencesEditor.apply()
    }

}