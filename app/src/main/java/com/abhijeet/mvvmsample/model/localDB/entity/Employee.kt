package com.abhijeet.mvvmsample.model.localDB.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.OffsetDateTime

@Entity(tableName = "employee")
open class Employee(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    @ColumnInfo(name = "name") var name: String,
    @ColumnInfo(name = "email_id") var email_id: String,
    @ColumnInfo(name = "contact_no") var contact_no: String,
    @ColumnInfo(name = "gender") var gender: String,
    @ColumnInfo(name = "address") var address: String,
    @ColumnInfo(name = "city") var city: String,
    @ColumnInfo(name = "state") var state: String,
    @ColumnInfo(name = "country") var country: OffsetDateTime? = null,
    @ColumnInfo(name = "joined_date") var joined_date: OffsetDateTime? = null,
    @ColumnInfo(name = "created") var created: String,
    @ColumnInfo(name = "password") var password: String
)