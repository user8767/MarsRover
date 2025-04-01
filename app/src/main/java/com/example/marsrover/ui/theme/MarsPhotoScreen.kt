package com.example.marsrover.ui.theme
import androidx.compose.foundation.lazy.items  // Import items function for LazyColumn

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.marsrover.data.MarsPhoto
import com.example.marsrover.viewmodel.MarsViewModel

@Composable
fun MarsPhotoScreen(viewModel: MarsViewModel) {
    val photos = viewModel.photos

    // LazyColumn for scrolling list of Mars photos
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(photos) { photo: MarsPhoto ->
            MarsPhotoItem(photo) // Use MarsPhotoItem to display each photo
        }
    }}