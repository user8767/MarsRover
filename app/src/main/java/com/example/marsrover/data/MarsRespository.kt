package com.example.marsrover.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MarsRepository {

    // Create Retrofit instance for API calls
    private val api = Retrofit.Builder()
        .baseUrl("https://api.nasa.gov/") // Base URL for NASA API
        .addConverterFactory(GsonConverterFactory.create()) // Convert JSON response
        .build()
        .create(MarsApiService::class.java) // Create API service

    // Fetch Mars photos from the API
    suspend fun fetchMarsPhotos(): List<MarsPhoto> {
        return withContext(Dispatchers.IO) { // Run network request on IO thread
            val response = api.getMarsPhotos(1000, "DEMO_KEY") // Fetch photos
            response.photos // Return list of Mars photos
        }
    }
}
