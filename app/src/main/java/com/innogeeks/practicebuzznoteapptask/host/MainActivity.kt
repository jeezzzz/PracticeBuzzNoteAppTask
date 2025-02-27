package com.innogeeks.practicebuzznoteapptask.host

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.innogeeks.practicebuzznoteapptask.navigation.NavGraph
import com.innogeeks.practicebuzznoteapptask.ui.theme.PracticeBuzzNoteAppTaskTheme
import com.innogeeks.practicebuzznoteapptask.viewmodel.NoteViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PracticeBuzzNoteAppTaskTheme {
                val navController = rememberNavController()
                val viewModel: NoteViewModel = viewModel()
                NavGraph(navController, viewModel)
            }
        }
    }
}

