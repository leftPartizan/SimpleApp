package com.example.simpleapp.data.entities

import androidx.recyclerview.widget.DiffUtil

data class People(
    val id: Int,
    val name: String,
    val height: String,
    val mass: String,
    val birthYear: String,
    val gender: String
) {
    companion object Diff : DiffUtil.ItemCallback<People>() {
        override fun areItemsTheSame(oldItem: People, newItem: People): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: People, newItem: People): Boolean {
            return oldItem == newItem
        }
    }
}