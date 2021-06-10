package com.example.simpleapp.ui.activity.fragments.settings

import androidx.lifecycle.LiveData
import io.reactivex.rxjava3.core.Completable

interface SettingsViewModel {

    val userName: LiveData<String>
    val userEmail: LiveData<String>
    fun saveSettings(userName: String, userEmail: String): Completable
    fun getSettings()
    fun moveToBack()
}