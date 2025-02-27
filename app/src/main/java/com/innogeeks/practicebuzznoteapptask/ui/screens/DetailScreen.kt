package com.innogeeks.practicebuzznoteapptask.ui.screens

import android.widget.Space
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.innogeeks.practicebuzznoteapptask.viewmodel.NoteViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteDetailScreen(navController: NavController, viewModel: NoteViewModel, noteId: Int?){

    val note = viewModel.getNoteById(noteId)

    Scaffold(topBar = { TopAppBar(
        title = { Text("Note Details") }) }) {  padding->

        Column(modifier = Modifier
            .padding(padding)
            .fillMaxSize()
            .padding(16.dp)) {

            if(note!=null){
                Text(note.title)
                Spacer(modifier = Modifier.height(8.dp))
                Text(note.content)
                Spacer(modifier = Modifier.height(8.dp))
            }
            else{
                Text("No Note Found")
                Spacer(modifier = Modifier.height(8.dp))
            }
        }

    }

}