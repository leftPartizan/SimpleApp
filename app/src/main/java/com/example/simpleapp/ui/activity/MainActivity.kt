package com.example.simpleapp.ui.activity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.simpleapp.utills.ViewModelFactory
import com.example.simpleapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!
    private val adapter: Adapter by lazy {
        Adapter()
    }

    private val viewModel: MainViewModel by viewModels { ViewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel.updateAllMovies()
        viewModel.listOfMovie.observe(this, { adapter.submitList(it) })
        binding.recyclerView.adapter = adapter
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}