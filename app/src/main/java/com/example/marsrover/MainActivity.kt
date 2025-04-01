package com.example.marsrover

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.marsrover.data.MarsRepository
import com.example.marsrover.ui.theme.MarsPhotoScreen
import com.example.marsrover.ui.theme.MarsRoverTheme
import com.example.marsrover.viewmodel.MarsViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val repository = MarsRepository()

        val viewModel = MarsViewModel(repository)

        setContent {
            MarsRoverTheme {
                MarsPhotoScreen(viewModel)
            }
        }
    }
}

