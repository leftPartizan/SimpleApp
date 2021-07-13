package com.example.simpleapp.data.repository.userSettings

import android.content.Context
import android.content.SharedPreferences
import androidx.preference.PreferenceManager
import com.example.simpleapp.data.entities.UserSettings
import com.example.simpleapp.domain.repositories.SettingsRepository
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class SettingsRepositoryImpl @Inject constructor(
    context: Context
) : SettingsRepository {

    private val prefs: SharedPreferences by lazy {
        PreferenceManager.getDefaultSharedPreferences(context)
    }

    private val userName
        get() = prefs.getString(USER_NAME, "") ?: ""

    private val userEmail
        get() = prefs.getString(USER_EMAIL, "") ?: ""

    override fun saveSettings(userSettings: UserSettings): Completable {
        return Completable.fromAction {
            val edit = prefs.edit()
            edit.putString(USER_NAME, userSettings.userName)
            edit.putString(USER_EMAIL, userSettings.userEmail)
            edit.apply()
        }.subscribeOn(Schedulers.io())
    }

    private fun getSettingsFromPref(): UserSettings {
        return UserSettings(userName, userEmail)
    }

    override fun getSettings(): Single<UserSettings> {
        return Single.fromCallable(::getSettingsFromPref)
            .subscribeOn(Schedulers.io())
    }

    companion object {
        const val USER_NAME = "USER_NAME"
        const val USER_EMAIL = "USER_EMAIL"
    }
}
