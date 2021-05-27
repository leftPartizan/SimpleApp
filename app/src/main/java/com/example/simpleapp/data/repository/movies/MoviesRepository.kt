package com.example.simpleapp.data.repository.movies

import com.example.simpleapp.data.entities.ItemMovie
import io.reactivex.rxjava3.core.Single

interface MoviesRepository {

    fun getAllMovies(forceUpdateCache: Boolean = false): Single<List<ItemMovie>>
}