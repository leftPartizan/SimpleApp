package com.example.simpleapp.data.database.movies

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movies")
data class MovieEntity(

    @ColumnInfo(name = "title")
    val title: String,

    @PrimaryKey
    val episodeId: String,

    @ColumnInfo(name = "opening_crawl")
    val openingCrawl: String,

    @ColumnInfo(name = "director")
    val director: String,

    @ColumnInfo(name = "producer")
    val producer: String,

    @ColumnInfo(name = "release_date")
    val releaseDate: String,

    @ColumnInfo(name = "characters_id")
    val charactersId: List<Int>
)
