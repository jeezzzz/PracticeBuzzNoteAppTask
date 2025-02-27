package com.innogeeks.practicebuzznoteapptask.ui.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DismissValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberSwipeToDismissBoxState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.innogeeks.practicebuzznoteapptask.navigation.Screen
import com.innogeeks.practicebuzznoteapptask.viewmodel.NoteViewModel

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(navController: NavController, viewModel: NoteViewModel){

    val notes by viewModel.notes.collectAsState()
    var noteToDelete by remember { mutableStateOf<Int?>(null) }
    if(noteToDelete !=null){
        AlertDialog(
            onDismissRequest = { noteToDelete = null },
            title = { Text("Delete Node")},
            text = { Text("Are you sure?")},
            confirmButton = {
                TextButton(onClick = {
                    viewModel.deleteNode(noteToDelete!!)
                    noteToDelete=null
                }) {
                    Text("Delete")
                }
            },
            dismissButton = {
                TextButton(onClick = {
                    viewModel.deleteNode(noteToDelete!!)
                    noteToDelete=null
                }){
                    Text("Cancel")
                }
            }
        )
    }

    Scaffold(topBar = { TopAppBar(
        title = { Text("Notes") }) },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {navController.navigate(Screen.AddNote.route)}
            )
            {
                Text("+")
            }
        }) {  padding->

        Column(modifier = Modifier
            .padding(padding)
            .fillMaxSize()
            .padding(16.dp)) {

            if(notes.isEmpty()){
                Text("No Notes avaliable")
            }else{
                LazyColumn {
                    items(notes, key = { it.id }){ note ->
                       Card(modifier = Modifier
                           .fillMaxWidth()
                           .padding(8.dp)
                           .clickable{ navController.navigate(Screen.NoteDetails.passId((note.id)))}
                           .combinedClickable(
                               onClick = { navController.navigate(Screen.NoteDetails.passId(note.id))},
                               onLongClick = { noteToDelete = note.id}
                           ),
                           elevation = CardDefaults.cardElevation(4.dp)){
                           Column(modifier = Modifier.padding(16.dp)){
                               Text(note.title)
                               Text(note.content)
                           }
                       }
                    }
                }
            }

    }

    }

}