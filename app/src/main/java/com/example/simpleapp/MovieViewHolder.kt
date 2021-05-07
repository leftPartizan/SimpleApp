package com.example.simpleapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.simpleapp.databinding.ItemMovieBinding


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