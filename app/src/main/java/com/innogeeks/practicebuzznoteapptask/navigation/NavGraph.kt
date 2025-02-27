package com.innogeeks.practicebuzznoteapptask.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.innogeeks.practicebuzznoteapptask.ui.screens.AddNoteScreen
import com.innogeeks.practicebuzznoteapptask.ui.screens.HomeScreen
import com.innogeeks.practicebuzznoteapptask.ui.screens.NoteDetailScreen
import com.innogeeks.practicebuzznoteapptask.viewmodel.NoteViewModel

@Composable
fun NavGraph(navController: NavHostController, noteViewModel: NoteViewModel = viewModel()){

    NavHost(navController= navController, startDestination = Screen.Home.route){
        composable(Screen.Home.route) {
            HomeScreen(navController, noteViewModel)
        }

        composable(Screen.AddNote.route) {
            AddNoteScreen(navController, noteViewModel)
        }

        composable(Screen.NoteDetails.route) {
            backStackEntry->
            val noteId = backStackEntry.arguments?.getString("notedId")?.toIntOrNull()
            noteId.let {
                NoteDetailScreen(navController, noteViewModel, it)
            }
        }
    }

}