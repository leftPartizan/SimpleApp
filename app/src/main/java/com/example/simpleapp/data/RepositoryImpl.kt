package com.example.simpleapp.data

import com.example.simpleapp.data.network.SwapiService
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val swapiService: SwapiService
) : Repository {

    override fun getAllMovies(): Single<List<ItemMovie>> {
        return swapiService.getAllMovies()
            .subscribeOn(Schedulers.io())
            .map { it.toListItemMovies() }
    }
}