package com.example.simpleapp.data.repository.movies

import com.example.simpleapp.data.database.movies.MoviesDao
import com.example.simpleapp.data.entities.ItemMovie
import com.example.simpleapp.data.entities.toItemMovie
import com.example.simpleapp.data.entities.toMoviesEntity
import com.example.simpleapp.data.network.SwapiService
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class MoviesRepositoryImpl @Inject constructor(
    private val swapiService: SwapiService,
    private val moviesDao: MoviesDao
) : MoviesRepository {

    private fun getAllMoviesFromDB(): Maybe<List<ItemMovie>> {
        return moviesDao.getAllMovies()
            .subscribeOn(Schedulers.io())
            .map { list ->
                list.map { it.toItemMovie() }
            }
    }

    private fun getAllMoviesFromNetwork(): Single<List<ItemMovie>> {
        return swapiService.getAllMovies()
            .subscribeOn(Schedulers.io())
            .map { it.toListItemMovies() }
            .doOnSuccess { list ->
                moviesDao.updateAllMovies(list.map { it.toMoviesEntity() })
            }
    }

    override fun getAllMovies(forceUpdateCache: Boolean): Single<List<ItemMovie>> {
        return if (forceUpdateCache) {
            getAllMoviesFromNetwork()
        } else {
            getAllMoviesFromDB().switchIfEmpty(getAllMoviesFromNetwork())
        }
    }
}