package com.example.marsrover.data

import com.google.gson.annotations.SerializedName

data class MarsPhoto(
    @SerializedName("id") val id: String,
    @SerializedName("img_src") val imgSrc: String,

)

data class MarsPhotoResponse(
    @SerializedName("photos") val photos: List<MarsPhoto>
)