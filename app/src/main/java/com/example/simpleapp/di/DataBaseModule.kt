package com.example.simpleapp.di

import android.content.Context
import com.example.simpleapp.data.database.DataBase
import com.example.simpleapp.data.database.movies.MoviesDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataBaseModule {

    @Provides
    @Singleton
    fun provideMovieDao(context: Context): MoviesDao {
        return DataBase.getInstance(context).getMoviesDao()
    }
}