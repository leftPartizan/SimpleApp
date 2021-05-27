package com.example.simpleapp.ui.activity.fragments.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.simpleapp.data.entities.ItemMovie
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.addTo
import javax.inject.Inject

class MainViewModelImpl @Inject constructor(
    private val mainInteractorImpl: MainInteractor
) : ViewModel(), MainViewModel {

    override val listOfMovies = MutableLiveData<List<ItemMovie>>()
    private val compositeDisposable = CompositeDisposable()

    override fun updateAllMovies(forceUpdateCache: Boolean) {
        mainInteractorImpl.getAllMovies(forceUpdateCache)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    if (forceUpdateCache) listOfMovies.postValue(emptyList())
                    listOfMovies.postValue(it)
                }, {
                    //  do nothing
                }
            ).addTo(compositeDisposable)
    }

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }
}