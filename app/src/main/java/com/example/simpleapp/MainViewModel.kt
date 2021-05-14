package com.example.simpleapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers

class MainViewModel(interactorImpl: Interactor) : ViewModel() {


    private val _listOfMovie = MutableLiveData<List<ItemMovie>>()
    val listOfMovie: LiveData<List<ItemMovie>>
        get() = _listOfMovie

    init {
        interactorImpl.getAllMovie()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    _listOfMovie.postValue(it)
                }, {
                    //  do nothing
                }
            )
    }

}