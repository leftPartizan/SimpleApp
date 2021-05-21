package com.example.simpleapp.di

import androidx.lifecycle.ViewModel
import com.example.simpleapp.di.viewmodeiInjector.ViewModelKey
import com.example.simpleapp.ui.activity.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    fun bindUserViewModel(mainViewModel: MainViewModel): ViewModel

}