package com.example.noted.repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.noted.db.roomdatabase.LocalDatabase
import com.example.noted.db.roomdatabase.notes.NoteDao
import com.example.noted.db.roomdatabase.notes.NoteEntity

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