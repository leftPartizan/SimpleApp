package com.example.simpleapp.core

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.example.simpleapp.ui.activity.fragments.main.MainFragment
import com.example.simpleapp.ui.activity.fragments.settings.SettingsFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object Screens {

    object settingsFragment : FragmentScreen {
        override fun createFragment(factory: FragmentFactory): Fragment {
            return SettingsFragment()
        }
    }

    object mainFragment : FragmentScreen {
        override fun createFragment(factory: FragmentFactory): Fragment {
            return MainFragment()
        }
    }
}