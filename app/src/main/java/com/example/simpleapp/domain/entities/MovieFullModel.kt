package com.example.simpleapp.domain.entities

import androidx.recyclerview.widget.DiffUtil
import com.example.simpleapp.data.entities.People

data class MovieFullModel(
    val title: String,
    val episodeId: String,
    val openingCrawl: String,
    val producer: String,
    val releaseDate: String,
    val charactersInfo: List<People>
) {
    companion object Diff : DiffUtil.ItemCallback<MovieShortModel>() {
        override fun areItemsTheSame(oldItem: MovieShortModel, newItem: MovieShortModel): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(oldItem: MovieShortModel, newItem: MovieShortModel): Boolean {
            return oldItem == newItem
        }
    }
}