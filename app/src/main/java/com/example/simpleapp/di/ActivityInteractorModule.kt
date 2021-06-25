package com.example.simpleapp.di

import com.example.simpleapp.domain.interactors.MainInteractor
import com.example.simpleapp.domain.interactors.MainInteractorImpl
import com.example.simpleapp.domain.interactors.SettingsInteractor
import com.example.simpleapp.domain.interactors.SettingsInteractorImpl
import dagger.Binds
import dagger.Module

@Module
interface ActivityInteractorModule {

    @Binds
    fun bindMainInteractor(interactor: MainInteractorImpl): MainInteractor

    @Binds
    fun bindSettingsInteractor(settingsInteractor: SettingsInteractorImpl): SettingsInteractor
}