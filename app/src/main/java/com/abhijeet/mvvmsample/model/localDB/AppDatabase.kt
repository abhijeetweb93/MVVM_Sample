package com.abhijeet.mvvmsample.model.localDB

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.abhijeet.mvvmsample.app_const.DATABASE_NAME
import com.abhijeet.mvvmsample.model.localDB.dao.DataProvider
import com.abhijeet.mvvmsample.model.localDB.entity.Employee
import com.abhijeet.mvvmsample.model.localDB.entity.Notes

//@Database(
//    entities = [Employee::class, Employee::class],
//    version = 1
//)
@Database(entities = arrayOf(Employee::class,Notes::class), version = 1, exportSchema = false)
@TypeConverters(Converters::class)
public abstract class AppDatabase  : RoomDatabase() {

    abstract fun databaseServiceDao(): DataProvider

//    companion object {
//        @Volatile
//        private var instance: AppDatabase? = null
//        private val LOCK = Any()
//
//        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
//            instance ?: buildDatabase(context).also { instance = it }
//        }
//
//        private fun buildDatabase(context: Context) = Room.databaseBuilder(
//            context,
//            AppDatabase::class.java, DATABASE_NAME
//        ).build()
//    }


    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    DATABASE_NAME
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }

}