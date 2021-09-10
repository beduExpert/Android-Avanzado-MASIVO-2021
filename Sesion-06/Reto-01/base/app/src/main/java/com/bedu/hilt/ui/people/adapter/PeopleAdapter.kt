package com.bedu.hilt.ui.people.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bedu.hilt.R
import com.bedu.hilt.data.model.People
import com.bedu.hilt.databinding.ItemLayoutBinding
import com.bumptech.glide.Glide

class PeopleAdapter(
    private val people: ArrayList<People>,
    private val imagePath: String
) : RecyclerView.Adapter<PeopleAdapter.DataViewHolder>() {

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(model: People, imagePath: String) {

            val binding = ItemLayoutBinding.bind(itemView)

            binding.textViewUserName.text = model.name
            binding.textViewUserEmail.text = model.gender
            Glide.with(binding.imageViewAvatar.context)
                .load(imagePath)
                .into(binding.imageViewAvatar)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DataViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_layout, parent,
                false
            )
        )

    override fun getItemCount(): Int = people.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) =
        holder.bind(people[position], imagePath)

    fun addData(list: List<People>) {
        people.clear()
        people.addAll(list)
    }
}