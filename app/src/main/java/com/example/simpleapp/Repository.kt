package com.example.simpleapp

import io.reactivex.rxjava3.core.Single

interface Repository {

    fun getAllMovie(): Single<List<ItemMovie>>
}