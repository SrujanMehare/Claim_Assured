package com.example.claimassured.my_garage.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.claimassured.databinding.DynamicCardviewItemBinding
import com.example.claimassured.my_garage.model.MyGarageModel

class GarageAdapter(private val garageList: List<MyGarageModel>) :
    RecyclerView.Adapter<GarageAdapter.GarageViewHolder>() {

    class GarageViewHolder(val binding: DynamicCardviewItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GarageViewHolder {
        val binding =
            DynamicCardviewItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GarageViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GarageViewHolder, position: Int) {
        val currentItem = garageList[position]
        holder.binding.cardDetails = currentItem
    }

    override fun getItemCount(): Int = garageList.size
}