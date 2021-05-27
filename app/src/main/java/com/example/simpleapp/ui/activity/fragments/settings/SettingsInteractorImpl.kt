package com.example.simpleapp.ui.activity.fragments.settings

import com.example.simpleapp.data.entities.UserSettings
import com.example.simpleapp.data.repository.userSettings.SettingsRepository
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class SettingsInteractorImpl @Inject constructor(
    private val settingsRepository: SettingsRepository
) : SettingsInteractor {
    override fun saveSettings(userSettings: UserSettings): Completable {
        return settingsRepository.saveSettings(userSettings)
    }

    override fun getSettings(): Single<UserSettings> {
        return settingsRepository.getSettings()
    }
}