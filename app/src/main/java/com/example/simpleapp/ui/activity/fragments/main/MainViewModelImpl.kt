package com.example.simpleapp.ui.activity.fragments.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.simpleapp.core.BaseViewModel
import com.example.simpleapp.core.Screens
import com.example.simpleapp.domain.entities.MovieShortModel
import com.example.simpleapp.domain.interactors.MainInteractor
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.kotlin.addTo
import java.util.*
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class MainViewModelImpl @Inject constructor(
    private val interactor: MainInteractor,
    router: Router
) : BaseViewModel(router), MainViewModel {

    override val listOfMovies: MutableLiveData<List<MovieShortModel>> =
        MutableLiveData<List<MovieShortModel>>()

    override fun initViewModel() {
        updateMovies(false)
    }

    override fun onMovieClick(movieId: String) {
        navigateTo(Screens.MovieScreen(movieId))
    }

    override fun onRefreshMovies() {
        listOfMovies.postValue(emptyList())
        updateMovies(true)
    }

    override fun moveToSettingsScreen() {
        navigateTo(Screens.SettingsScreen)
    }

    private fun updateMovies(forceUpdateCache: Boolean) {
        Observable.timer(1, TimeUnit.SECONDS).subscribe() { interactor.getAllMovies(forceUpdateCache)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    listOfMovies.postValue(it)
                }, {
                    //  do nothing
                }
            ).addTo(compositeDisposable)
        }
    }
}