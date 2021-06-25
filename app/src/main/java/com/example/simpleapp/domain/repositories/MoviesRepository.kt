package com.example.simpleapp.domain.repositories

import com.example.simpleapp.data.entities.Movie
import io.reactivex.rxjava3.core.Single

interface MoviesRepository {

    fun getAllMovies(forceUpdateCache: Boolean = false): Single<List<Movie>>
    fun getMovie(id: String): Single<Movie>
}