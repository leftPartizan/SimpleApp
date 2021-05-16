package com.example.simpleapp.ui.activity

import com.example.simpleapp.data.ItemMovie
import io.reactivex.rxjava3.core.Single

interface Interactor {
    fun getAllMovies(): Single<List<ItemMovie>>
}
