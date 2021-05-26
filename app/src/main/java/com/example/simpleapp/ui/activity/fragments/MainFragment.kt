package com.example.simpleapp.ui.activity.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.simpleapp.R
import com.example.simpleapp.databinding.FragmentMainBinding
import com.example.simpleapp.ui.activity.Adapter
import com.example.simpleapp.ui.activity.IMainViewModel
import com.example.simpleapp.ui.activity.MainActivity
import com.example.simpleapp.ui.activity.MainViewModel
import okhttp3.internal.notify
import okhttp3.internal.notifyAll
import javax.inject.Inject

class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    private val adapter: Adapter by lazy {
        Adapter()
    }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: IMainViewModel by viewModels<MainViewModel> {
        viewModelFactory
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        (activity as MainActivity).activitySubComponent.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(layoutInflater, container, false)
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.listOfMovies.observe(viewLifecycleOwner) {
            adapter.submitList(it)
            binding.swipeRefresh.isRefreshing = false
        }
        viewModel.updateAllMovies()
        binding.recyclerView.adapter = adapter
        binding.swipeRefresh.setOnRefreshListener {
            viewModel.updateAllMovies(true)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}