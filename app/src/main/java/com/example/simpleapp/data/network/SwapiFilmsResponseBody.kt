package com.example.simpleapp.data.network

import android.os.Parcelable
import com.example.simpleapp.data.database.entities.ItemMovie
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

data class SwapiFilmsResponseBody(
    @SerializedName("count") val count: Int,
    @SerializedName("results") val results: List<SwapiFilm>
) {
    fun toListItemMovies(): List<ItemMovie> = results.map { it.getMovie() }
}

@Parcelize
data class SwapiFilm(
    @SerializedName("title") val title: String,
    @SerializedName("episode_id") val episode_id: String,
    @SerializedName("opening_crawl") val opening_crawl: String,
    @SerializedName("producer") val producer: String,
    @SerializedName("release_date") val release_date: String,
) : Parcelable {

    fun getMovie() = ItemMovie(
        title = title,
        episode_id = episode_id,
        opening_crawl = opening_crawl,
        producer = producer,
        release_date = release_date
    )
}