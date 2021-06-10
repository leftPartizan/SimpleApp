package com.example.simpleapp.ui.activity.fragments.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.simpleapp.databinding.FragmentMainBinding
import com.example.simpleapp.ui.activity.MainActivity
import com.example.simpleapp.utills.observeNonNullState
import javax.inject.Inject


class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    private val adapter: Adapter by lazy {
        Adapter()
    }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: MainViewModel by viewModels<MainViewModelImpl> {
        viewModelFactory
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        (activity as MainActivity).activitySubComponent?.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
        initListenerForViews()
        subscribeToViewModelChanges()
    }

    private fun initView() {
        binding.recyclerView.adapter = adapter
    }

    private fun subscribeToViewModelChanges() {
        viewModel.initViewModel()
        observeNonNullState(viewModel.listOfMovies) {
            adapter.submitList(it)
            binding.swipeRefresh.isRefreshing = false
        }
    }

    private fun initListenerForViews() {
        binding.swipeRefresh.setOnRefreshListener {
            viewModel.onRefreshMovies()
        }
        binding.toolbarContent.mainButtonToolbarOpenSettings.setOnClickListener {
            viewModel.moveToSettingsScreen()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}