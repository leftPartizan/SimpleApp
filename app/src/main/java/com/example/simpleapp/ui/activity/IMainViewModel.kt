package com.example.simpleapp.ui.activity

import androidx.lifecycle.LiveData
import com.example.simpleapp.data.ItemMovie

interface IMainViewModel {

    val listOfMovies : LiveData<List<ItemMovie>>
    fun updateAllMovies()
}