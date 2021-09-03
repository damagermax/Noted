package com.example.noted.db.roomdatabase.todos

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface ToDoDao {

    @Query("SELECT * FROM tasks ORDER BY taskId ASC")
    fun realAllTask(): LiveData<List<ToDoEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertTask(toDo: ToDoEntity)

    @Delete
    fun deleteTask(toDo: ToDoEntity)

    @Update
    fun updateTask(toDo: ToDoEntity)


    @Query("SELECT * FROM tasks WHERE taskTitle Like :searchInput")
    fun searchTask(searchInput: String): LiveData<List<ToDoEntity>>
}