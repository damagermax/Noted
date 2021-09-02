package com.example.noted.datas.roomdatabase.notes

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NoteDao {

    @Query("SELECT * FROM notes ORDER BY noteId ASC")
    fun realAllNotes(): LiveData<List<NoteEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertNote(note: NoteEntity)

    @Delete
    fun deleteNote(note: NoteEntity)

    @Update
    fun updateNote(note: NoteEntity)


    @Query("SELECT * FROM NOTES WHERE noteTitle Like :searchInput")
    fun searchNote(searchInput: String): LiveData<List<NoteEntity>>
}