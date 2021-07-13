package com.example.simpleapp.ui.activity.fragments.main

import com.example.simpleapp.data.database.movies.MovieEntity
import com.example.simpleapp.data.entities.Movie
import com.example.simpleapp.data.network.MovieDTO
import javax.inject.Inject

class MovieMapper @Inject constructor() {

    fun mapDtoToEntity(movieDTO: MovieDTO): MovieEntity {
        return movieDTO.run {
            MovieEntity(
                title = title,
                episodeId = episodeId,
                director = director,
                openingCrawl = openingCrawl,
                producer = producer,
                releaseDate = releaseDate,
                charactersId = charactersURL.map { it[it.length - 2].code }
            )
        }
    }

    fun mapEntityToMovieDomain(movieEntity: MovieEntity): Movie {
        return movieEntity.run {
            Movie(
                title = title,
                episodeId = episodeId,
                director = director,
                openingCrawl = openingCrawl,
                producer = producer,
                releaseDate = releaseDate,
                charactersId = charactersId
            )
        }
    }

    fun mapDtoToMovieDomain(movieDTO: MovieDTO): Movie {
        return movieDTO.run {
            Movie(
                title = title,
                episodeId = episodeId,
                director = director,
                openingCrawl = openingCrawl,
                producer = producer,
                releaseDate = releaseDate,
                charactersId = charactersURL.map { it[it.length - 2].code }
            )
        }
    }

    fun mapMovieDomainToEntity(movie: Movie): MovieEntity {
        return movie.run {
            MovieEntity(
                title = title,
                episodeId = episodeId,
                director = director,
                openingCrawl = openingCrawl,
                producer = producer,
                releaseDate = releaseDate,
                charactersId = charactersId
            )
        }
    }
}