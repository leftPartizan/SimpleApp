package com.example.simpleapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

@SuppressWarnings("unchecked")
object ViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(interactorImpl = InteractorImpl(RepositoryImpl())) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}