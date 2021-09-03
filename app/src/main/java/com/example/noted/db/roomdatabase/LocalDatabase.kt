package com.example.noted.db.roomdatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.noted.db.roomdatabase.notes.NoteDao
import com.example.noted.db.roomdatabase.notes.NoteEntity
import com.example.noted.db.roomdatabase.todos.ToDoDao
import com.example.noted.db.roomdatabase.todos.ToDoEntity

@Database(
    entities = [NoteEntity::class,ToDoEntity::class],
    version = 2
)
abstract class LocalDatabase:RoomDatabase() {

   /*--------- database dao -------------*/
    abstract fun noteDao(): NoteDao
    abstract fun taskDao(): ToDoDao
    /*-----------------------------------*/




    companion object {

        @Volatile
        private var DATABASE: LocalDatabase? = null

        fun createDataBase(context: Context): LocalDatabase {
            val oldDataBase = DATABASE
            if (oldDataBase != null) {
                return oldDataBase
            }
            synchronized(this) {
                val newDataBase = Room.databaseBuilder(
                    context.applicationContext,
                    LocalDatabase::class.java,
                    "noted_database"
                ).build()
                DATABASE = newDataBase

                return newDataBase
            }
        }
    }
}