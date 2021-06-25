package com.example.simpleapp.data.network

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

data class MovieResponseBody(
    @SerializedName("results") val results: List<MovieDTO>
)

@Parcelize
data class MovieDTO(
    @SerializedName("title") val title: String,
    @SerializedName("episode_id") val episodeId: String,
    @SerializedName("opening_crawl") val openingCrawl: String,
    @SerializedName("director") val director: String,
    @SerializedName("producer") val producer: String,
    @SerializedName("release_date") val releaseDate: String,
    @SerializedName("characters") val charactersURL: List<String>,
) : Parcelable