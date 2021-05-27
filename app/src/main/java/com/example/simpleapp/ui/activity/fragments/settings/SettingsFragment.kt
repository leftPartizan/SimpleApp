package com.example.simpleapp.ui.activity.fragments.settings

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.simpleapp.databinding.FragmentSettingsBinding
import com.example.simpleapp.ui.activity.MainActivity
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.addTo
import javax.inject.Inject

class SettingsFragment : Fragment() {

    private var _binding: FragmentSettingsBinding? = null
    private val binding get() = _binding!!

    private val compositeDisposable = CompositeDisposable()

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
        (activity as MainActivity).activitySubComponent.inject(this)
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
        viewModel.getSettings()
        viewModel.userEmail.observe(viewLifecycleOwner) {
            binding.userEmail.text.append(it)
        }
        viewModel.userName.observe(viewLifecycleOwner) {
            binding.userName.text.append(it)
        }
        binding.saveSettings.setOnClickListener {
            viewModel.saveSettings(userName, userEmail).subscribe(
                {
                    parentFragmentManager.popBackStack()
                    Log.d("www", "save st")
                }, {
                    // do nothing
                }
            ).addTo(compositeDisposable)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
        compositeDisposable.clear()
    }
}