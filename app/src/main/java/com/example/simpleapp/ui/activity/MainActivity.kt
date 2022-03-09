package com.example.simpleapp.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.simpleapp.R
import com.example.simpleapp.app.App
import com.example.simpleapp.core.Screens
import com.example.simpleapp.databinding.ActivityMainBinding
import com.example.simpleapp.di.ActivitySubComponent
import com.github.terrakok.cicerone.Forward
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.androidx.AppNavigator
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!
    var activitySubComponent: ActivitySubComponent? = null

    private val navigator: AppNavigator by lazy {
        AppNavigator(this, R.id.fragment_container_view)
    }

    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    override fun onCreate(savedInstanceState: Bundle?) {
        activitySubComponent = App.appComponent.activitySubComponent().create(this)
        activitySubComponent?.inject(this)
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        navigator.applyCommands(arrayOf(Forward(Screens.MainScreen)))
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        navigatorHolder.removeNavigator()
    }

    override fun onDestroy() {
        super.onDestroy()
        activitySubComponent = null
        _binding = null

    }
}