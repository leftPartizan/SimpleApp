package com.example.simpleapp.data.database.entities

import androidx.recyclerview.widget.DiffUtil
import com.example.simpleapp.data.database.movies.MoviesEntity

data class ItemMovie(
    val id: Long?,
    val title: String,
    val episode_id: String,
    val opening_crawl: String,
    val producer: String,
    val release_date: String,
) {
    companion object Diff : DiffUtil.ItemCallback<ItemMovie>() {
        override fun areItemsTheSame(oldItem: ItemMovie, newItem: ItemMovie): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(oldItem: ItemMovie, newItem: ItemMovie): Boolean {
            return oldItem == newItem
        }
    }
}

fun ItemMovie.toMoviesEntity(): MoviesEntity {
    return MoviesEntity(
        id = id,
        title = title,
        episode_id = episode_id,
        opening_crawl = opening_crawl,
        producer = producer,
        release_date = release_date
    )
}

fun MoviesEntity.toItemMovie(): ItemMovie {
    return ItemMovie(
        id = id,
        title = title,
        episode_id = episode_id,
        opening_crawl = opening_crawl,
        producer = producer,
        release_date = release_date
    )
}