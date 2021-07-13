package com.example.simpleapp.core

import androidx.lifecycle.ViewModel
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.Screen
import io.reactivex.rxjava3.disposables.CompositeDisposable
import javax.inject.Inject

open class BaseViewModel @Inject constructor(
    private val router: Router
) : ViewModel() {

    protected val compositeDisposable = CompositeDisposable()

    fun navigateTo(screen: Screen) {
        router.navigateTo(screen)
    }

    fun onBackPressed() {
        router.exit()
    }

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }
}