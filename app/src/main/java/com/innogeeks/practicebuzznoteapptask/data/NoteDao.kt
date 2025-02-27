package com.innogeeks.practicebuzznoteapptask.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao{

//    @Upsert
//    suspend fun insertNode(note: Note)
//
//    @Delete
//    suspend fun deleteNode(note: Note)
//
////    @Query("SELECT * FROM notes ORDER BY id DESC ")
////    suspend fun getAllNotes(): Flow<List<Note>>

}