package com.example.simpleapp.ui.activity.fragments.movie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.simpleapp.data.entities.People
import com.example.simpleapp.databinding.ItemPeopleBinding

class PeopleAdapter :
    ListAdapter<People, PeopleAdapter.PeopleViewHolder>(People) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeopleViewHolder {
        return PeopleViewHolder(parent)
    }

    override fun onBindViewHolder(holder: PeopleViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun getItemCount(): Int {
        return currentList.size
    }

    class PeopleViewHolder(
        private val itemPeopleView: ItemPeopleBinding,
    ) :
        RecyclerView.ViewHolder(itemPeopleView.root) {

        constructor(parent: ViewGroup) : this(
            ItemPeopleBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

        fun bind(item: People) {
            with(itemPeopleView) {
                peopleName.text = item.name
                peopleHeight.text = item.height
                peopleMass.text = item.mass
                peopleBirthYear.text = item.birthYear
                peopleGender.text = item.gender
            }
        }
    }
}