package com.example.noted.datas.roomdatabase.tasks

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tasks")
class TaskEntity(

    @PrimaryKey(autoGenerate = true)
    val taskId: Int,
    val taskTitle: String,
    val dueDate: String,
    val dateCreated: String,
    val isDone: Boolean

)