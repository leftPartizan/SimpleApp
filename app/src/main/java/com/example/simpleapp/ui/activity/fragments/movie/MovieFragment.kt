package com.example.simpleapp.ui.activity.fragments.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.simpleapp.databinding.FragmentMovieBinding
import com.example.simpleapp.ui.activity.MainActivity
import com.example.simpleapp.utills.observeNonNullState
import javax.inject.Inject

class MovieFragment : Fragment() {

    private val id = arguments?.getString(MOVIE_ID) ?: "1"
    private var _binding: FragmentMovieBinding? = null
    private val binding get() = _binding!!
    private val adapter = PeopleAdapter()

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: MovieViewModel by viewModels<MovieViewModelImpl> {
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
        _binding = FragmentMovieBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
        subscribeToViewModelChanges()
    }

    private fun initView() {
        binding.rwFragmentMovie.adapter = adapter
    }

    private fun subscribeToViewModelChanges() {
        viewModel.getMovie(id)
        observeNonNullState(viewModel.movie) {

            with(binding) {
                titleMovie.text = it.title
                episodeMovie.text = it.episodeId
                producerMovie.text = it.producer
                releaseDateMovie.text = it.releaseDate
                openingCrawlMovieText.text = it.openingCrawl

                adapter.submitList(it.charactersInfo)
            }
        }
        observeNonNullState(viewModel.error) {
            Toast.makeText(requireContext(), "что-то пошло не так", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        const val MOVIE_ID = "MOVIE_ID"
    }
}