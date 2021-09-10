package com.bedu.hilt.ui.planets.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bedu.hilt.R
import com.bedu.hilt.data.model.Planet
import com.bedu.hilt.databinding.ItemLayoutBinding
import com.bumptech.glide.Glide

class PlanetsAdapter(
    private val planet: ArrayList<Planet>,
    private val imagePath: String
) : RecyclerView.Adapter<PlanetsAdapter.DataViewHolder>() {

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(model: Planet, imagePath: String) {

            val binding = ItemLayoutBinding.bind(itemView)

            binding.textViewUserName.text = model.name
            binding.textViewUserEmail.text = model.population
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

    override fun getItemCount(): Int = planet.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) =
        holder.bind(planet[position], imagePath)

    fun addData(list: List<Planet>) {
        planet.clear()
        planet.addAll(list)
    }
}