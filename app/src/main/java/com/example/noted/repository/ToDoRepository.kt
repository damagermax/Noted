package com.example.noted.repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.noted.db.roomdatabase.LocalDatabase
import com.example.noted.db.roomdatabase.todos.ToDoEntity
import com.example.noted.db.roomdatabase.todos.ToDoDao

class ToDoRepository(application: Application) {

    private val readAllToDO:LiveData<List<ToDoEntity>>
    private val todoDao:ToDoDao = LocalDatabase.createDataBase(application).taskDao()

    init {

        readAllToDO=todoDao.realAllTask()
    }

    fun reaAllToDo():LiveData<List<ToDoEntity>>{
        return readAllToDO
    }

    fun insertTask(toDo: ToDoEntity){
        todoDao.insertTask(toDo)
    }


    fun deleteTask(toDo: ToDoEntity){
        todoDao.deleteTask(toDo)
    }


    fun updateTask(toDo: ToDoEntity){
        todoDao.updateTask(toDo)
    }



    fun searchTask(searchInput: String): LiveData<List<ToDoEntity>>{
        return  todoDao.searchTask(searchInput )
    }

}