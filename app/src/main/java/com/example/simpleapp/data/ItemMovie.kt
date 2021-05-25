package com.example.simpleapp.data

import androidx.recyclerview.widget.DiffUtil

data class ItemMovie(
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