package com.example.simpleapp.data.network

import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface SwapiService {

    @GET("films/")
    fun getAllMovies(): Single<MovieResponseBody>

    @GET("films/{id}/")
    fun getMovie(@Path("id") id: Int): Single<MovieResponseBody>

    @GET("people/{id}/")
    fun getPeople(@Path("id") id: Int): Single<PeopleDTO>
}