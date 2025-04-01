package com.example.marsrover.ui.theme

import com.example.marsrover.data.MarsPhoto
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter

@Composable
fun MarsPhotoItem(photo: MarsPhoto) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(4.dp), // Elevation for visual appeal
        shape = RoundedCornerShape(12.dp) // Rounded corners
    ) {
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            // Load and display the Mars image with an aspect ratio
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f) // Adjust based on the actual image ratio
            ) {
                Image(
                    painter = rememberImagePainter(photo.imgSrc), // Fetch image using Coil
                    contentDescription = "Mars Photo",
                    modifier = Modifier.fillMaxSize(), // Make the image fill the Box
                    contentScale = ContentScale.Crop // Crop or fit the image to the aspect ratio
                )
            }
            Spacer(modifier = Modifier.height(8.dp)) // Add space below the image
            // Display the photo ID below the image
            Text(
                text = "Photo ID: ${photo.id}",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.align(Alignment.CenterHorizontally) // Center the text
            )
        }
    }
}