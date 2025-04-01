package com.example.marsrover.viewmodel

import android.util.Log
import android.util.Log.e
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.marsrover.data.MarsPhoto
import com.example.marsrover.data.MarsRepository
import kotlinx.coroutines.launch

class MarsViewModel (private  val respository: MarsRepository) : ViewModel(){
    var photos by mutableStateOf<List<MarsPhoto>>(emptyList())
        private set

    init{
        fetchMarsPhotos()
    }



    private fun fetchMarsPhotos(){
        viewModelScope.launch {
            try {
                photos = respository.fetchMarsPhotos()
                Log.d("MarsViewModel", "Fetched ${photos.size} photos")
                photos.forEach { Log.d("MarsViewModel", "Photo URL: ${it.imgSrc}") }
            }
            catch (e: Exception) {
                // Handle the error
                e.printStackTrace()
                Log.e("MarsViewModel", "Error fetching photos: ${e.message}", e)

            }
            Log.d("MarsRepository", "Fetched ${photos.size} photos")
        }
    }
}