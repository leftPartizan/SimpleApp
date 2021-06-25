package com.example.simpleapp.data.database.movies

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.rxjava3.core.Maybe

@Dao
interface MoviesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateMovie(movieEntity: MovieEntity): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun updateAllMovies(listMovieEntity: List<MovieEntity>)

    @Query("SELECT * FROM movies")
    fun getAllMovies(): Maybe<List<MovieEntity>>

    @Query("SELECT * FROM movies where episodeId = :episodeId")
    fun getMovie(episodeId : String): Maybe<MovieEntity>
}