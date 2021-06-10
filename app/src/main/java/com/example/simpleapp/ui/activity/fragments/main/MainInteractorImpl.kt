package com.example.simpleapp.ui.activity.fragments.main

import com.example.simpleapp.data.entities.ItemMovie
import com.example.simpleapp.data.repository.movies.MoviesRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject


class MainInteractorImpl @Inject constructor(
    private val moviesRepository: MoviesRepository
) : MainInteractor {

    override fun getAllMovies(forceUpdateCache: Boolean): Single<List<ItemMovie>> {
        return moviesRepository.getAllMovies(forceUpdateCache)
    }
}