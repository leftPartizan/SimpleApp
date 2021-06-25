package com.example.simpleapp.ui.activity.fragments.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.simpleapp.databinding.FragmentSettingsBinding
import com.example.simpleapp.ui.activity.MainActivity
import com.example.simpleapp.ui.activity.fragments.settings.SettingsViewModel
import com.example.simpleapp.ui.activity.fragments.settings.SettingsViewModelImpl
import com.example.simpleapp.utills.observeNonNullState
import javax.inject.Inject

class SettingsFragment : Fragment() {

    private var _binding: FragmentSettingsBinding? = null
    private val binding get() = _binding!!

    private val userName
        get() = binding.userName.text.toString()
    private val userEmail
        get() = binding.userEmail.text.toString()

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: SettingsViewModel by viewModels<SettingsViewModelImpl> {
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
    ): View? {
        _binding = FragmentSettingsBinding.inflate(layoutInflater, container, false)
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        subscribeToViewModelChanges()
        initListenerForViews()
    }

    private fun subscribeToViewModelChanges() {
        viewModel.initViewModel()
        observeNonNullState(viewModel.userName) {
            binding.userName.text.append(it)
        }
        observeNonNullState(viewModel.userEmail) {
            binding.userEmail.text.append(it)
        }
    }

    private fun initListenerForViews() {
        binding.saveSettings.setOnClickListener {
            viewModel.saveSettingsAndMoveToBack(userName, userEmail)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}