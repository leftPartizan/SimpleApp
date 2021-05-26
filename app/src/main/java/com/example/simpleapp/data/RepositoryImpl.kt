package com.example.simpleapp.data

import android.util.Log
import com.example.simpleapp.data.database.entities.ItemMovie
import com.example.simpleapp.data.database.entities.toItemMovie
import com.example.simpleapp.data.database.entities.toMoviesEntity
import com.example.simpleapp.data.database.movies.MoviesDao
import com.example.simpleapp.data.network.SwapiService
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val swapiService: SwapiService,
    private val moviesDao: MoviesDao
) : Repository {

    private fun getAllMoviesFromDB():Single<List<ItemMovie>> {
        return moviesDao.getAllMovies()
            .subscribeOn(Schedulers.io())
            .map { list ->
                list.map { it.toItemMovie() } }
    }

    private fun getAllMoviesFromNetwork():Single<List<ItemMovie>> {
        return swapiService.getAllMovies()
            .subscribeOn(Schedulers.io())
            .map { it.toListItemMovies() }
    }

    override fun getAllMovies(forceUpdateCache : Boolean): Single<List<ItemMovie>> {
        return getAllMoviesFromDB().flatMap { list ->
            if (list.isEmpty() || forceUpdateCache) {
                getAllMoviesFromNetwork()
                    .doOnSuccess { list ->
                        moviesDao.updateAllMovies(list.map { it.toMoviesEntity() }) }
            } else Single.just(list)
        }
    }
}