package com.example.noted.datas.repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.noted.datas.roomdatabase.LocalDatabase
import com.example.noted.datas.roomdatabase.notes.NoteDao
import com.example.noted.datas.roomdatabase.notes.NoteEntity

class NoteRepository(application: Application) {

    val readAllNotes: LiveData<List<NoteEntity>>

    private val noteDao: NoteDao

    init {
        val dataBase = LocalDatabase.createDataBase(application)
        noteDao = dataBase.noteDao()
        readAllNotes = noteDao.realAllNotes()

    }
    fun insertNote(note: NoteEntity){
        noteDao.insertNote(note)
    }
    fun deleteNote(note: NoteEntity){
        noteDao.deleteNote(note)

    }
    fun updateNote(note: NoteEntity){
        noteDao.deleteNote(note)
    }

    fun searchNote(searchInput: String): LiveData<List<NoteEntity>>{
        return noteDao.searchNote(searchInput)
    }

}