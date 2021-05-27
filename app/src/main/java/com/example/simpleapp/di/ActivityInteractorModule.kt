package com.example.simpleapp.di

import com.example.simpleapp.ui.activity.fragments.main.MainInteractor
import com.example.simpleapp.ui.activity.fragments.main.MainInteractorImpl
import com.example.simpleapp.ui.activity.fragments.settings.SettingsInteractor
import com.example.simpleapp.ui.activity.fragments.settings.SettingsInteractorImpl
import dagger.Binds
import dagger.Module

@Module
interface ActivityInteractorModule {

    @Binds
    fun bindMainInteractor(interactor: MainInteractorImpl): MainInteractor

    @Binds
    fun bindSettingsInteractor(settingsInteractor: SettingsInteractorImpl): SettingsInteractor
}