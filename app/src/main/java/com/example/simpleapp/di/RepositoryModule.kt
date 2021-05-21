package com.example.simpleapp.di

import com.example.simpleapp.data.Repository
import com.example.simpleapp.data.RepositoryImpl
import dagger.Binds
import dagger.Module

@Module
interface RepositoryModule {

    @Binds
    fun bindMainRepository(repository: RepositoryImpl) : Repository
}