package com.innogeeks.practicebuzznoteapptask.navigation

sealed class Screen(val route: String){
    data object Home: Screen("home")
    data object AddNote: Screen("add_note")
    data object NoteDetails: Screen("note_details/{note_id}"){
        fun passId(noteId: Int) = "note_details/$noteId"
    }
}