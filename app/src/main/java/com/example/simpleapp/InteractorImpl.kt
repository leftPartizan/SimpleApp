package com.example.simpleapp

import io.reactivex.rxjava3.core.Single


class InteractorImpl(private val repository: Repository) : Interactor {

    override fun getAllMovie(): Single<List<ItemMovie>> {
        return repository.getAllMovie()
    }
}