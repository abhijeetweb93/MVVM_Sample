package com.abhijeet.mvvmsample.model.localDB.dao

import androidx.room.*
import com.abhijeet.mvvmsample.model.localDB.entity.Employee
import com.abhijeet.mvvmsample.model.localDB.entity.Notes

@Dao
interface DataProvider {

    @Query("SELECT * FROM employee")
    fun getAll(): List<Employee>

    @Query("SELECT * FROM employee WHERE email_id LIKE :emailId")
    fun findByEmail(emailId: String): Employee

    @Insert
    fun insertAll(vararg employee: Employee)

    @Delete
    fun delete(employee: Employee)

    @Update
    fun updateEmploye(vararg employees: Employee)

    @Query("SELECT * FROM employee WHERE email_id = :emailId and password=:password")
    fun isUserValid(emailId: String, password: String): Employee

    @Query("SELECT * FROM notes")
    fun getAllNotes(): List<Notes>

    @Query("SELECT * FROM notes WHERE id = :id")
    fun getNotes(id:Long): Notes

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNotes(note: Notes):Long

    @Update
    fun updateNotes(note: Notes):Int



}