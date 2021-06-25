package com.example.simpleapp.core

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.example.simpleapp.ui.activity.fragments.main.MainFragment
import com.example.simpleapp.ui.activity.fragments.movie.MovieFragment
import com.example.simpleapp.ui.activity.fragments.settings.SettingsFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object Screens {

    object SettingsScreen : FragmentScreen {
        override fun createFragment(factory: FragmentFactory): Fragment {
            return SettingsFragment()
        }
    }

    object MainScreen : FragmentScreen {
        override fun createFragment(factory: FragmentFactory): Fragment {
            return MainFragment()
        }
    }

    class MovieScreen(private val arg: String) : FragmentScreen {
        override fun createFragment(factory: FragmentFactory): Fragment {
            return MovieFragment()
                .apply {
                    arguments = Bundle().apply {
                        putString(MovieFragment.ARGUMENT, arg) } }
        }
    }
}