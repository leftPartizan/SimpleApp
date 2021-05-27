package com.example.simpleapp.ui.activity.fragments.settings

import com.example.simpleapp.data.entities.UserSettings
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

interface SettingsInteractor {
    fun saveSettings(userSettings: UserSettings): Completable
    fun getSettings(): Single<UserSettings>
}