package com.example.simpleapp.ui.activity.fragments.main

import androidx.lifecycle.MutableLiveData
import com.example.simpleapp.core.BaseViewModel
import com.example.simpleapp.core.Screens
import com.example.simpleapp.data.entities.ItemMovie
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.kotlin.addTo
import javax.inject.Inject

class MainViewModelImpl @Inject constructor(
    private val interactor: MainInteractor,
    router: Router
) : BaseViewModel(router), MainViewModel {

    override val listOfMovies = MutableLiveData<List<ItemMovie>>()

    override fun updateAllMovies(forceUpdateCache: Boolean) {
        interactor.getAllMovies(forceUpdateCache)
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

    override fun moveToSettingsScreen() {
        onOpenNewScreen(Screens.settingsFragment)
    }
}