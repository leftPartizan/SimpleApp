package com.example.simpleapp.ui.activity.fragments.movie

import androidx.lifecycle.LiveData
import com.example.simpleapp.domain.entities.MovieFullModel
import java.lang.Exception

interface MovieViewModel {

    val movie: LiveData<MovieFullModel>
    val error: LiveData<Throwable>
    fun getMovie(id: String)
}