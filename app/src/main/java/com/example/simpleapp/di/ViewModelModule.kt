package com.example.simpleapp.di

import androidx.lifecycle.ViewModel
import com.example.simpleapp.di.viewmodeiInjector.ViewModelKey
import com.example.simpleapp.ui.activity.fragments.main.MainViewModelImpl
import com.example.simpleapp.ui.activity.fragments.movie.MovieViewModelImpl
import com.example.simpleapp.ui.activity.fragments.settings.SettingsViewModelImpl
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModelImpl::class)
    fun bindMainViewModel(mainViewModelImpl: MainViewModelImpl): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SettingsViewModelImpl::class)
    fun bindSettingsViewModel(mainViewModelImpl: SettingsViewModelImpl): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MovieViewModelImpl::class)
    fun bindMovieViewModel(mainViewModelImplImpl: MovieViewModelImpl): ViewModel
}