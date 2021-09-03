package com.example.noted.db.roomdatabase.todos

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tasks")
class ToDoEntity(

    @PrimaryKey(autoGenerate = true)
    val taskId: Int,
    val taskTitle: String,
    val dueDate: String,
    val dateCreated: String,
    val isDone: Boolean

)