package com.example.simpleapp.di

import com.example.simpleapp.ui.activity.Interactor
import com.example.simpleapp.ui.activity.InteractorImpl
import dagger.Binds
import dagger.Module

@Module
interface ActivityInteractorModule {

    @Binds
    fun bindActivityInteractor(interactor: InteractorImpl): Interactor
}