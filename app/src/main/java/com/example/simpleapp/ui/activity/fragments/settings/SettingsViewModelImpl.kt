package com.example.simpleapp.ui.activity.fragments.settings

import androidx.lifecycle.MutableLiveData
import com.example.simpleapp.core.BaseViewModel
import com.example.simpleapp.data.entities.UserSettings
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.kotlin.addTo
import javax.inject.Inject

class SettingsViewModelImpl @Inject constructor(
    private val interactor: SettingsInteractor,
    router: Router
) : BaseViewModel(router), SettingsViewModel {

    override val userName = MutableLiveData<String>()
    override val userEmail = MutableLiveData<String>()

    override fun saveSettings(userName: String, userEmail: String): Completable {
        return interactor.saveSettings(
            UserSettings(
                userName = userName,
                userEmail = userEmail
            )
        ).observeOn(AndroidSchedulers.mainThread())
    }

    override fun getSettings() {
        interactor.getSettings().observeOn(AndroidSchedulers.mainThread())
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

    override fun moveToBack() {
        onBackPressed()
    }

}