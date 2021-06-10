package com.example.simpleapp.ui.activity.fragments.main

import com.example.simpleapp.data.entities.ItemMovie
import io.reactivex.rxjava3.core.Single

interface MainInteractor {
    fun getAllMovies(forceUpdateCache: Boolean = false): Single<List<ItemMovie>>
}
