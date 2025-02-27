package com.innogeeks.practicebuzznoteapptask.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.innogeeks.practicebuzznoteapptask.data.Note
import com.innogeeks.practicebuzznoteapptask.data.NoteDatabase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class NoteViewModel: ViewModel() {

    private val _notes = MutableStateFlow<List<Note>>(emptyList())
    val notes = _notes.asStateFlow()

    fun addNote(title: String, content: String){
        val newNote = Note(id = _notes.value.size + 1, title=title, content=content)
        _notes.value = listOf(newNote)+_notes.value
    }

    fun deleteNode(noteId: Int){
        _notes.value = _notes.value.filter { it.id != noteId }
    }

    fun getNoteById(noteId: Int?): Note? {
        return _notes.value.find {it.id == noteId}
    }
}