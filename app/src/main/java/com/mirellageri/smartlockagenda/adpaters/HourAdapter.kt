package com.mirellageri.smartlockagenda.adpaters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mirellageri.smartlockagenda.data.BlockHour
import com.mirellageri.smartlockagenda.databinding.ItemHourBinding

class HourAdapter(
    var items: List<BlockHour>,
    val onItemClick:(position: Int)-> Unit
) : RecyclerView.Adapter<HourViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HourViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemHourBinding.inflate(layoutInflater,parent,false)
        return HourViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HourViewHolder, position: Int) {
        val hour = items[position]
        holder.render(hour)
        holder.itemView.setOnClickListener {
            onItemClick(position)
        }
    }
    override fun getItemCount(): Int = items.size
}

class HourViewHolder(val binding: ItemHourBinding): RecyclerView.ViewHolder(binding.root){
    fun render(hour: BlockHour){
        binding.hourTextView.text = hour.hour
        //binding.titleTaskTextView.text = hour.titleTask
    }
}