package com.example.simpleapp.app

import android.app.Application
import com.example.simpleapp.di.AppComponent

class App : Application() {

    companion object {
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        initDagger()
    }

    fun initDagger() {
        appComponent = AppComponent.create(this)
    }
}