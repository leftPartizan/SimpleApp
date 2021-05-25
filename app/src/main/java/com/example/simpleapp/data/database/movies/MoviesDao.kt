package com.example.simpleapp.data.database.movies

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

@Dao
interface MoviesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateTask(moviesEntity: MoviesEntity): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun updateAllMovies(listMoviesEntity: List<MoviesEntity>)

    @Query("SELECT * FROM movies")
    fun getAllMovies() : Single<List<MoviesEntity>>
}