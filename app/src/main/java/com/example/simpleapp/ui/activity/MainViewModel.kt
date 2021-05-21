package com.example.simpleapp.ui.activity

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.simpleapp.data.ItemMovie
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val interactorImpl: Interactor) : ViewModel(), IMainViewModel {

    val listOfMovie = MutableLiveData<List<ItemMovie>>()

    override fun updateAllMovies() {
        interactorImpl.getAllMovies()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    listOfMovie.postValue(it)
                }, {
                    //  do nothing
                }
            )
    }
}