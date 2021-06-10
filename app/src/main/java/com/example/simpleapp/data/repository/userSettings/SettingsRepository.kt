package com.example.simpleapp.data.repository.userSettings

import com.example.simpleapp.data.entities.UserSettings
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

interface SettingsRepository {

    fun saveSettings(userSettings: UserSettings): Completable
    fun getSettings(): Single<UserSettings>
}
