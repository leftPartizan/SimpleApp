package com.example.simpleapp.domain.entities

import androidx.recyclerview.widget.DiffUtil

data class MovieShortModel(
    val title: String,
    val episodeId: String,
    val openingCrawl: String,
    val producer: String,
    val releaseDate: String,
) {
    companion object Diff : DiffUtil.ItemCallback<MovieShortModel>() {
        override fun areItemsTheSame(oldItem: MovieShortModel, newItem: MovieShortModel): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(
            oldItem: MovieShortModel,
            newItem: MovieShortModel
        ): Boolean {
            return oldItem == newItem
        }
    }
}