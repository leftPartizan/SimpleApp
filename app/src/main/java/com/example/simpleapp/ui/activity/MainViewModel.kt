package com.example.simpleapp.ui.activity

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.simpleapp.data.database.entities.ItemMovie
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.addTo
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val interactorImpl: Interactor
) : ViewModel(), IMainViewModel {

    override val listOfMovies = MutableLiveData<List<ItemMovie>>()
    private val compositeDisposable = CompositeDisposable()

    override fun updateAllMovies(forceUpdateCache: Boolean) {
        interactorImpl.getAllMovies(forceUpdateCache)
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