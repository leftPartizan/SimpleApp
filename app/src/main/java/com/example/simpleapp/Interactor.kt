package com.example.simpleapp

import io.reactivex.rxjava3.core.Single

interface Interactor {
    fun getAllMovie(): Single<List<ItemMovie>>
}
