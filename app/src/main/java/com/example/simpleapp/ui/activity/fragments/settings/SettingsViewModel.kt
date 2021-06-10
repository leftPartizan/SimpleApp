package com.example.simpleapp.ui.activity.fragments.settings

import androidx.lifecycle.LiveData

interface SettingsViewModel {

    val userName: LiveData<String>
    val userEmail: LiveData<String>
    fun saveSettingsAndMoveToBack(userName: String, userEmail: String)
    fun initViewModel()
}