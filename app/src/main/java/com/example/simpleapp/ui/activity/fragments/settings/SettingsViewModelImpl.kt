package com.example.simpleapp.ui.activity.fragments.settings

import androidx.lifecycle.MutableLiveData
import com.example.simpleapp.core.BaseViewModel
import com.example.simpleapp.data.entities.UserSettings
import com.example.simpleapp.domain.interactors.SettingsInteractor
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.kotlin.addTo
import javax.inject.Inject

class SettingsViewModelImpl @Inject constructor(
    private val interactor: SettingsInteractor,
    router: Router
) : BaseViewModel(router), SettingsViewModel {

    override val userName = MutableLiveData<String>()
    override val userEmail = MutableLiveData<String>()

    override fun saveSettingsAndMoveToBack(userName: String, userEmail: String) {
        interactor.saveSettings(
            UserSettings(
                userName = userName,
                userEmail = userEmail
            )
        )
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { onBackPressed() }
    }

    override fun initViewModel() {
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
}