package com.example.simpleapp.data

import androidx.recyclerview.widget.DiffUtil

data class ItemMovie(
    val name: String,
    val genres: String,
    val rating: String
) {

    companion object Diff : DiffUtil.ItemCallback<ItemMovie>() {
        override fun areItemsTheSame(oldItem: ItemMovie, newItem: ItemMovie): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: ItemMovie, newItem: ItemMovie): Boolean {
            return oldItem == newItem
        }
    }
}