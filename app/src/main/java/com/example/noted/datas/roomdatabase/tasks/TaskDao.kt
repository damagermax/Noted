package com.example.noted.datas.roomdatabase.tasks

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface TaskDao {

    @Query("SELECT * FROM tasks ORDER BY taskId ASC")
    fun realAllTask(): LiveData<List<TaskEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertTask(task: TaskEntity)

    @Delete
    fun deleteTask(task: TaskEntity)

    @Update
    fun updateTask(task: TaskEntity)


    @Query("SELECT * FROM tasks WHERE taskTitle Like :searchInput")
    fun searchTask(searchInput: String): LiveData<List<TaskEntity>>
}