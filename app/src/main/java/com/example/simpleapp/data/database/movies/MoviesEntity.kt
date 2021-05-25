package com.example.simpleapp.data.database.movies

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "movies")
data class MoviesEntity(

    @PrimaryKey(autoGenerate = true)
    val id : Long?,

    @ColumnInfo(name = "title")
    val title: String,

    @ColumnInfo(name = "episode_id")
    val episode_id: String,

    @ColumnInfo(name = "opening_crawl")
    val opening_crawl: String,

    @ColumnInfo(name = "producer")
    val producer: String,

    @ColumnInfo(name = "release_date")
    val release_date: String,
)
