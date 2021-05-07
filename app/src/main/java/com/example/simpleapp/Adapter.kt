package com.example.simpleapp

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter

class Adapter : ListAdapter<ItemMovie, MovieViewHolder>(ItemMovie.Diff) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(parent)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun getItemCount(): Int {
        return currentList.size
    }
}