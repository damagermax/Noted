package com.example.noted.datas.roomdatabase.notes

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "notes")
data class NoteEntity(

    @PrimaryKey(autoGenerate = true)
    val noteId: Int,
    val noteTitle: String,
    val noteBody: String,
    val date: String

)
