package com.example.simpleapp.data.database.movies

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Single

@Dao
interface MoviesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateMovie(moviesEntity: MoviesEntity): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun updateAllMovies(listMoviesEntity: List<MoviesEntity>)

    @Query("SELECT * FROM movies")
    fun getAllMovies(): Maybe<List<MoviesEntity>>
}