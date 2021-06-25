package com.example.simpleapp.data.repository.movies

import android.util.Log
import com.example.simpleapp.data.database.movies.MoviesDao
import com.example.simpleapp.data.entities.Movie
import com.example.simpleapp.data.network.SwapiService
import com.example.simpleapp.domain.repositories.MoviesRepository
import com.example.simpleapp.ui.activity.fragments.main.MovieMapper
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class MoviesRepositoryImpl @Inject constructor(
    private val swapiService: SwapiService,
    private val moviesDao: MoviesDao,
    private val movieMapper: MovieMapper
) : MoviesRepository {

    private fun getMovieFromDB(id: String): Maybe<Movie> {
        return moviesDao.getMovie(id)
            .subscribeOn(Schedulers.io())
            .map(movieMapper::mapEntityToMovieDomain)
    }

    private fun getAllMoviesFromDB(): Maybe<List<Movie>> {
        return moviesDao.getAllMovies()
            .subscribeOn(Schedulers.io())
            .map { it.map(movieMapper::mapEntityToMovieDomain) }
            .doOnError { Log.d("www", "it $it") }
            .doOnSuccess { Log.d("www", "it $it")  }
    }

    private fun getAllMoviesFromNetwork(): Single<List<Movie>> {
        return swapiService.getAllMovies()
            .subscribeOn(Schedulers.io())
            .map { Log.d("www", "${it}")
                it.results.map(movieMapper::mapDtoToMovieDomain) }
            .doOnSuccess { list ->
                moviesDao.updateAllMovies(list.map(movieMapper::mapMovieDomainToEntity))
            }
    }

    override fun getAllMovies(forceUpdateCache: Boolean): Single<List<Movie>> {
        return if (forceUpdateCache) {
            getAllMoviesFromNetwork()
        } else {
            getAllMoviesFromDB().switchIfEmpty(getAllMoviesFromNetwork())
        }
    }

    override fun getMovie(id: String): Single<Movie> {
        return getMovieFromDB(id)
            .switchIfEmpty(
                getAllMoviesFromNetwork()
                    .toObservable()
                    .flatMap { Observable.fromIterable(it) }
                    .filter { it.episodeId == id }
                    .firstOrError()
            )
    }
}