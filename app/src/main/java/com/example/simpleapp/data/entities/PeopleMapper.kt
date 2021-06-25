package com.example.simpleapp.data.entities

import com.example.simpleapp.data.network.PeopleDTO
import javax.inject.Inject

class PeopleMapper @Inject constructor() {

    fun mapDtoToPeopleDomain(id: Int, people: PeopleDTO): People {
        return people.run {
            People(
                id = id,
                name = name,
                height = height,
                mass = mass,
                birthYear = birthYear,
                gender = gender
            )
        }
    }
}