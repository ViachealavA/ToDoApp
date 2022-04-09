package com.vperelygin.todoapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity  //что такое?
data class Todo(
    @ColumnInfo(name = "title")
    var title: String,
    @ColumnInfo(name = "notes")
    var notes: String
)  {
    @PrimaryKey(autoGenerate = true)
    var uuid: Int = 0

}