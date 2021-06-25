package com.example.simpleapp.ui.activity.fragments.main

import androidx.lifecycle.LiveData
import com.example.simpleapp.domain.entities.MovieShortModel

interface MainViewModel : MovieAdapter.OnMovieClickListener {

    val listOfMovies: LiveData<List<MovieShortModel>>
    fun onRefreshMovies()
    fun moveToSettingsScreen()
    fun initViewModel()
}