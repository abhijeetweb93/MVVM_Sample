package com.abhijeet.mvvmsample.model.localDB.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Date

@Entity(tableName = "notes")
open class Notes(
    @PrimaryKey(autoGenerate = true)
    var id: Int?,
    @ColumnInfo(name = "title") var title: String,
    @ColumnInfo(name = "notes_text") var notes_text: String,
    @ColumnInfo(name = "created") var created: Date? = null,
    @ColumnInfo(name = "updated") var updated: Date? = null

) {
    constructor() : this(null, "", "", null, null)
}