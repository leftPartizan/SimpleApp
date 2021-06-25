package com.example.simpleapp.data.entities

data class Movie(
    val title: String,
    val episodeId: String,
    val director: String,
    val openingCrawl: String,
    val producer: String,
    val releaseDate: String,
    val charactersId: List<Int>
)
