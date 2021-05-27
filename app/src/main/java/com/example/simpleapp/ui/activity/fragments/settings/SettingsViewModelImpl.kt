package com.example.simpleapp.ui.activity.fragments.settings

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.simpleapp.data.entities.UserSettings
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.addTo
import javax.inject.Inject

class SettingsViewModelImpl @Inject constructor(
    private val settingsInteractor: SettingsInteractor
) : ViewModel(), SettingsViewModel {

    override val userName = MutableLiveData<String>()
    override val userEmail = MutableLiveData<String>()

    private val compositeDisposable = CompositeDisposable()

    override fun saveSettings(userName: String, userEmail: String): Completable {
        return settingsInteractor.saveSettings(
            UserSettings(
                userName = userName,
                userEmail = userEmail
            )
        ).observeOn(AndroidSchedulers.mainThread())
    }

    override fun getSettings() {
        settingsInteractor.getSettings().observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    val (name, email) = it
                    userName.postValue(name)
                    userEmail.postValue(email)
                }, {
                    //do nothing
                }
            ).addTo(compositeDisposable)
    }

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }
}