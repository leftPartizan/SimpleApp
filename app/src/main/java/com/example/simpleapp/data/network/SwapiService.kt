package com.example.simpleapp.data.network

import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface SwapiService {

    @GET("films/")
    fun getAllMovies(): Single<SwapiFilmsResponseBody>
}