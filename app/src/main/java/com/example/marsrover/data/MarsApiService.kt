package com.example.marsrover.data

import retrofit2.http.GET
import retrofit2.http.Query

interface MarsApiService {
    @GET("mars-photos/api/v1/rovers/curiosity/photos")

    suspend fun getMarsPhotos(
        @Query("sol") sol: Int,
        @Query("api_key") apiKey: String,
    ): MarsPhotoResponse
}