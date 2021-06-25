package com.example.simpleapp.ui.activity.fragments.movie

import androidx.lifecycle.MutableLiveData
import com.example.simpleapp.core.BaseViewModel
import com.example.simpleapp.domain.entities.MovieFullModel
import com.example.simpleapp.domain.usecases.MovieUseCase
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.kotlin.addTo
import javax.inject.Inject

class MovieViewModel @Inject constructor(
    private val movieUseCase: MovieUseCase,
    router: Router
) : BaseViewModel(router) {

    val movie: MutableLiveData<MovieFullModel> = MutableLiveData<MovieFullModel>()

    fun getMovie(id: String) {
        movieUseCase.getMovieInfo(id)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                movie.postValue(it)
            }, {
                // no op
            }).addTo(compositeDisposable)
    }
}