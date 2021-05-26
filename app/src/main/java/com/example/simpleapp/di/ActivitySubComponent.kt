package com.example.simpleapp.di

import android.app.Activity
import com.example.simpleapp.di.scope.ActivityScope
import com.example.simpleapp.ui.activity.MainActivity
import com.example.simpleapp.ui.activity.fragments.MainFragment
import dagger.BindsInstance
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = [ActivityInteractorModule::class, ViewModelModule::class])
interface ActivitySubComponent {

    fun inject(mainActivity: MainActivity)
    fun inject(mainFragment: MainFragment)

    @Subcomponent.Factory
    interface Factory {
        fun create(@BindsInstance activity: Activity): ActivitySubComponent
    }
}