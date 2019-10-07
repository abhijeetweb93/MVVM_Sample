package com.abhijeet.mvvmsample.model.localDB

import androidx.room.*
import com.abhijeet.mvvmsample.model.localDB.entity.Employee

@Dao
interface DataProvider {

    @Query("SELECT * FROM employee")
    fun getAll(): List<Employee>

    @Query("SELECT * FROM employee WHERE email_id LIKE :emailId")
    fun findByTitle(emailId: String): Employee

    @Insert
    fun insertAll(vararg employee: Employee)

    @Delete
    fun delete(employee: Employee)

    @Update
    fun updateEmploye(vararg employees: Employee)
}