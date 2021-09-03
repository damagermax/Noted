package com.example.noted.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.noted.db.roomdatabase.todos.ToDoEntity
import com.example.noted.repository.ToDoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ToDoViewModel(application: Application) : AndroidViewModel(application) {

    private val readAllToDo: LiveData<List<ToDoEntity>>
    private val toDoRepository: ToDoRepository = ToDoRepository(application)

    init {
        readAllToDo = toDoRepository.reaAllToDo()
    }

    fun readAllToDo():LiveData<List<ToDoEntity>>{
        return readAllToDo
    }

    fun insertTask(toDo: ToDoEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            toDoRepository.insertTask(toDo)
        }
    }


    fun deleteTask(toDo: ToDoEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            toDoRepository.deleteTask(toDo)
        }

    }


    fun updateTask(toDo: ToDoEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            toDoRepository.updateTask(toDo)
        }

    }


    fun searchTask(searchInput: String): LiveData<List<ToDoEntity>> {
        return toDoRepository.searchTask(searchInput)
    }
}