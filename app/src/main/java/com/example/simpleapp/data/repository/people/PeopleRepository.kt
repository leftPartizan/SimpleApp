package com.example.simpleapp.data.repository.people

import com.example.simpleapp.data.entities.People
import com.example.simpleapp.data.entities.PeopleMapper
import com.example.simpleapp.data.network.SwapiService
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class PeopleRepository @Inject constructor(
    private val swapiService: SwapiService,
    private val mapper: PeopleMapper
) {
    fun getPeople(id: Int): Single<People> = swapiService
        .getPeople(id)
        .map{ mapper.mapDtoToPeopleDomain(id, it) }
        .subscribeOn(Schedulers.io())
}