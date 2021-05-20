package com.example.simpleapp.data

import io.reactivex.rxjava3.core.Single

interface Repository {

    fun getAllMovies(): Single<List<ItemMovie>>
}