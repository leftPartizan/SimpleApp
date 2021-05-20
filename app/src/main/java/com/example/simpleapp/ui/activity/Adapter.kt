package com.example.simpleapp.ui.activity

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.simpleapp.data.ItemMovie
import com.example.simpleapp.databinding.ItemMovieBinding

class Adapter : ListAdapter<ItemMovie, Adapter.MovieViewHolder>(ItemMovie.Diff) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(parent)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun getItemCount(): Int {
        return currentList.size
    }

    class MovieViewHolder(private val itemMovie: ItemMovieBinding) :
        RecyclerView.ViewHolder(itemMovie.root) {

        constructor(parent: ViewGroup) : this(
            ItemMovieBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

        fun bind(item: ItemMovie) {
            itemMovie.titleMovie.text = item.name
            itemMovie.genresMovie.text = item.genres
            itemMovie.ratingMovie.text = item.rating
        }
    }
}