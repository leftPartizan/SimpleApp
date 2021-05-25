package com.example.simpleapp.data

import com.example.simpleapp.data.database.entities.ItemMovie
import io.reactivex.rxjava3.core.Single

interface Repository {

    fun getAllMovies(): Single<List<ItemMovie>>
}