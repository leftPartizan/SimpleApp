package com.example.simpleapp.domain.usecases

import com.example.simpleapp.data.entities.Movie
import com.example.simpleapp.data.entities.People
import com.example.simpleapp.data.repository.people.PeopleRepository
import com.example.simpleapp.domain.entities.MovieFullModel
import com.example.simpleapp.domain.repositories.MoviesRepository
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class MovieUseCase @Inject constructor(
    private val movieRepository: MoviesRepository,
    private val peopleRepository: PeopleRepository
) {
    fun getMovieInfo(id: String): Single<MovieFullModel> {
        return movieRepository
            .getMovie(id)
            .flatMap { movie ->
                val people =
                    movie.charactersId.map { peopleRepository.getPeople(it).toObservable() }
                Observable.merge(people).toList()
                    .flatMap { Single.just(transformToMovieFullModel(movie, it)) }
            }
    }

    private fun transformToMovieFullModel(movie: Movie, people: List<People>) =
        MovieFullModel(
            title = movie.title,
            episodeId = movie.episodeId,
            openingCrawl = movie.openingCrawl,
            producer = movie.producer,
            releaseDate = movie.releaseDate,
            charactersInfo = people
        )
}