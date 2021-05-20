package com.example.simpleapp.ui.activity

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.simpleapp.data.ItemMovie
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers

class MainViewModel(private val interactorImpl: Interactor) : ViewModel(), IMainViewModel {


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