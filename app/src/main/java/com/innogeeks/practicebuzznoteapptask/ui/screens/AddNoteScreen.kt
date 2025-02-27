package com.innogeeks.practicebuzznoteapptask.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.innogeeks.practicebuzznoteapptask.navigation.Screen
import com.innogeeks.practicebuzznoteapptask.viewmodel.NoteViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddNoteScreen( navController: NavController, viewModel: NoteViewModel){
    var title by remember { mutableStateOf("") }
    var content by remember { mutableStateOf("") }

    Scaffold(topBar = { TopAppBar(
        title = { Text("Add Notes") }) }) {  padding->

        Column(modifier = Modifier
            .padding(padding)
            .fillMaxSize()
            .padding(16.dp)) {

            OutlinedTextField( value = title,
                onValueChange = {title=it},
                label = { Text("Title") })

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField( value = content,
                onValueChange = {content=it},
                label = { Text("Description") })

            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = {
                viewModel.addNote(title, content)
                navController.popBackStack()
            }) {
                Text("Save Note")
            }
        }

    }

}