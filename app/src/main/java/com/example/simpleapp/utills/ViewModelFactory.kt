package com.example.simpleapp.utills

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.simpleapp.ui.activity.InteractorImpl
import com.example.simpleapp.ui.activity.MainViewModel
import com.example.simpleapp.data.RepositoryImpl

@SuppressWarnings("unchecked")
object ViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(interactorImpl = InteractorImpl(RepositoryImpl())) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}