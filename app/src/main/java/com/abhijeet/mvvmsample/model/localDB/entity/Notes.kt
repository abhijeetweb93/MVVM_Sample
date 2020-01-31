package com.abhijeet.mvvmsample.model.localDB.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Date

@Entity(tableName = "notes")
open class Notes(
    @PrimaryKey(autoGenerate = true)
    var id: Long?,
    @ColumnInfo(name = "title") var title: String,
    @ColumnInfo(name = "notes_text") var notes_text: String,
    @ColumnInfo(name = "created") var created: Date? = Date(System.currentTimeMillis()),
    @ColumnInfo(name = "updated") var updated: Date? = Date(System.currentTimeMillis())

) {
    constructor() : this(null, "", "", null, null)
}