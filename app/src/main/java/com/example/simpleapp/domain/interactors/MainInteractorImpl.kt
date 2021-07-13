package com.example.simpleapp.domain.interactors

import com.example.simpleapp.data.entities.Movie
import com.example.simpleapp.domain.entities.MovieShortModel
import com.example.simpleapp.domain.repositories.MoviesRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject


class MainInteractorImpl @Inject constructor(
    private val moviesRepository: MoviesRepository
) : MainInteractor {

    override fun getAllMovies(forceUpdateCache: Boolean): Single<List<MovieShortModel>> {
        return moviesRepository.getAllMovies(forceUpdateCache)
            .flatMap { list ->
                Single.just(list.map(::mapToShortModel))
            }
    }

    private fun mapToShortModel(movie: Movie): MovieShortModel {
        return movie.run {
            MovieShortModel(
                title = title,
                episodeId = episodeId,
                openingCrawl = openingCrawl,
                producer = producer,
                releaseDate = releaseDate.take(130) + "..."
            )
        }
    }
}