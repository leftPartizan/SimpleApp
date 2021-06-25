package com.example.simpleapp.domain.interactors

import com.example.simpleapp.domain.entities.MovieShortModel
import io.reactivex.rxjava3.core.Single

interface MainInteractor {
    fun getAllMovies(forceUpdateCache: Boolean = false): Single<List<MovieShortModel>>
}
