package com.example.simpleapp.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.simpleapp.R
import com.example.simpleapp.app.App
import com.example.simpleapp.databinding.ActivityMainBinding
import com.example.simpleapp.di.ActivitySubComponent
import com.example.simpleapp.ui.activity.fragments.main.MainFragment

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!
    lateinit var activitySubComponent: ActivitySubComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        activitySubComponent = App.appComponent.activitySubComponent().create(this)
        activitySubComponent.inject(this)
        this.viewModelStore
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragment_container_view, MainFragment())
            .addToBackStack(null)
            .commit()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}