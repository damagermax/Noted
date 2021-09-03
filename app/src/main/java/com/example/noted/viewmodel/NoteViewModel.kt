package com.example.noted.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.noted.db.roomdatabase.notes.NoteEntity
import com.example.noted.repository.NoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteViewModel(application: Application):AndroidViewModel(application) {

    private val readAllNotes: LiveData<List<NoteEntity>>
    private val noteRepository: NoteRepository = NoteRepository(application)

    init {
        readAllNotes = noteRepository.readAllNotes

    }

    fun insertNote(note: NoteEntity){
       viewModelScope.launch(Dispatchers.IO) {
           noteRepository.insertNote(note)
       }
    }
    fun deleteNote(note: NoteEntity){
        viewModelScope.launch(Dispatchers.IO) {
            noteRepository.deleteNote(note)
        }
    }
    fun updateNote(note: NoteEntity){
        viewModelScope.launch(Dispatchers.IO) {
            noteRepository.updateNote(note)
        }
    }

    fun searchNote(searchInput: String): LiveData<List<NoteEntity>>{
        return noteRepository.searchNote(searchInput)
    }

}