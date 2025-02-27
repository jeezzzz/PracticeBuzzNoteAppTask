package com.innogeeks.practicebuzznoteapptask.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Note::class], version = 1, exportSchema = true)
abstract class NoteDatabase: RoomDatabase()
{
    abstract fun noteDao(): NoteDao

    companion object{
        private var INSTANCE: NoteDatabase? =null
    }

    fun getDatabase(context: Context): NoteDatabase{
        val db= Room.databaseBuilder(context.applicationContext,
            NoteDatabase::class.java,
            "note_database").build()
        INSTANCE
        return db
    }
}