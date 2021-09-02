package com.example.noted.datas.roomdatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.noted.datas.roomdatabase.notes.NoteDao
import com.example.noted.datas.roomdatabase.notes.NoteEntity
import com.example.noted.datas.roomdatabase.tasks.TaskDao
import com.example.noted.datas.roomdatabase.tasks.TaskEntity

@Database(
    entities = [NoteEntity::class,TaskEntity::class],
    version = 1
)
abstract class LocalDatabase:RoomDatabase() {

   /*--------- database daos-------------*/
    abstract fun noteDao(): NoteDao
    abstract fun taskDao(): TaskDao

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
                    "note_database"
                ).build()
                DATABASE = newDataBase

                return newDataBase
            }
        }
    }
}