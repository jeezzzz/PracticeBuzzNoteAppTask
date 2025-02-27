package com.innogeeks.practicebuzznoteapptask.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes")
data class Note(
    @PrimaryKey(autoGenerate = true) val id :Int=0,
    val title: String,
    val content: String
)

data class Notes(
    val id :Int,
    val title: String,
    val content: String
)