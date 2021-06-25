package com.example.simpleapp.ui.activity.fragments.main

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.simpleapp.databinding.ItemMovieBinding
import com.example.simpleapp.domain.entities.MovieShortModel

class MovieAdapter(private val listener: OnMovieClickListener) :
    ListAdapter<MovieShortModel, MovieAdapter.MovieViewHolder>(MovieShortModel.Diff) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(parent, listener)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun getItemCount(): Int {
        return currentList.size
    }

    class MovieViewHolder(
        private val itemMovie: ItemMovieBinding,
        private val listener: OnMovieClickListener
    ) :
        RecyclerView.ViewHolder(itemMovie.root) {

        constructor(parent: ViewGroup, listener: OnMovieClickListener) : this(
            ItemMovieBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            listener = listener
        )

        @SuppressLint("SetTextI18n")
        fun bind(item: MovieShortModel) {
            itemMovie.titleMovie.text = item.title
            itemMovie.episodeMovie.text = "episode ${item.episodeId}"
            itemMovie.openingCrawlMovieText.text = item.openingCrawl
            itemMovie.producerMovie.text = "producers: ${item.producer}"
            itemMovie.releaseDateMovie.text = item.releaseDate
            itemMovie.root.setOnClickListener {
                listener.onMovieClick(item.episodeId)
            }
        }
    }

    interface OnMovieClickListener {
        fun onMovieClick(movieId: String)
    }
}