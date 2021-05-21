package com.example.simpleapp.data

import com.example.simpleapp.utills.MoviesFactory
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class RepositoryImpl @Inject constructor() : Repository {

    override fun getAllMovies(): Single<List<ItemMovie>> {
        return Single.just(MoviesFactory.createListMovies())
            .delay(300, TimeUnit.MILLISECONDS)
            .subscribeOn(Schedulers.io())
    }
}