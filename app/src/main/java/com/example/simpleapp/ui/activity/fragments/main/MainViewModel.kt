package com.example.simpleapp.ui.activity.fragments.main

import androidx.lifecycle.LiveData
import com.example.simpleapp.data.entities.ItemMovie

interface MainViewModel {

    val listOfMovies: LiveData<List<ItemMovie>>
    fun onRefreshMovies()
    fun moveToSettingsScreen()
    fun initViewModel()
}