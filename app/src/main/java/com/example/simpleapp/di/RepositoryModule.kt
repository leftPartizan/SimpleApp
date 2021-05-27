package com.example.simpleapp.di

import com.example.simpleapp.data.repository.movies.MoviesRepository
import com.example.simpleapp.data.repository.movies.MoviesRepositoryImpl
import com.example.simpleapp.data.repository.userSettings.SettingsRepository
import com.example.simpleapp.data.repository.userSettings.SettingsRepositoryImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface RepositoryModule {

    @Binds
    @Singleton
    fun bindMainRepository(mainRepository: MoviesRepositoryImpl): MoviesRepository

    @Binds
    @Singleton
    fun bindSettingsRepository(settingsRepository: SettingsRepositoryImpl): SettingsRepository
}