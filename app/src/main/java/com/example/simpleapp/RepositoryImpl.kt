package com.example.simpleapp

import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class RepositoryImpl : Repository {

    val a = MoviesFactory.createListMovies()

    override fun getAllMovie(): Single<List<ItemMovie>> {
        return Single.just(MoviesFactory.createListMovies())
            .delay(300, TimeUnit.MILLISECONDS)
            .subscribeOn(Schedulers.io())
    }
}