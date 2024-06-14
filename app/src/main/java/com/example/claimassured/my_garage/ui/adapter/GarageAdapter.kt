package com.example.claimassured.my_garage.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.claimassured.databinding.DynamicCardviewItemBinding
import com.example.claimassured.ext.gone
import com.example.claimassured.ext.visible
import com.example.claimassured.my_garage.model.MyGarageModel
import com.example.claimassured.utils.swipe_button.OnActiveListener

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
        val currentItem = garageList[holder.adapterPosition]
        holder.binding.cardDetails = currentItem

        if (currentItem.isBtnSliderVisible) {
            holder.binding.btnSlider.visible()
        } else {
            holder.binding.btnSlider.gone()
        }

        holder.binding.btnSlider.apply {
            setOnActiveListener(object : OnActiveListener {
                override fun onActive() {
                    currentItem.isBtnSliderVisible = false
                    notifyItemChanged(holder.adapterPosition)
                }
            })
        }
    }

    override fun getItemCount(): Int = garageList.size
}