package com.example.simpleapp.ui.activity

import com.example.simpleapp.data.ItemMovie
import com.example.simpleapp.data.Repository
import io.reactivex.rxjava3.core.Single


class InteractorImpl(private val repository: Repository) : Interactor {

    override fun getAllMovies(): Single<List<ItemMovie>> {
        return repository.getAllMovies()
    }
}