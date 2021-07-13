package com.example.simpleapp.ui.activity.fragments.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.simpleapp.core.BaseViewModel
import com.example.simpleapp.domain.entities.MovieFullModel
import com.example.simpleapp.domain.usecases.MovieUseCase
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.kotlin.addTo
import java.lang.Exception
import javax.inject.Inject

class MovieViewModelImpl @Inject constructor(
    private val movieUseCase: MovieUseCase,
    router: Router
) : BaseViewModel(router), MovieViewModel{

    override val movie: MutableLiveData<MovieFullModel> = MutableLiveData<MovieFullModel>()
    override val error: MutableLiveData<Throwable> = MutableLiveData()

    override fun getMovie(id: String) {
        movieUseCase.getMovieInfo(id)
            .subscribe({
                movie.postValue(it)
            }, {
                error.postValue(it)
            })
            .addTo(compositeDisposable)
    }
}