package com.example.androidhomework.presentation.view.adapter.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidhomework.databinding.ItemGunBinding
import com.example.androidhomework.presentation.view.adapter.listener.ItemsListener
import com.example.androidhomework.domain.model.ItemsModel

class ItemsAdapter(
    private val itemsListener: ItemsListener
): RecyclerView.Adapter<ItemsViewHolder>() {

    private var listItems = mutableListOf<ItemsModel>()

    fun submitList(list: List<ItemsModel>){
        listItems.clear()
        listItems.addAll(list.toMutableList())
        this.notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemsViewHolder {
        val viewBinding = ItemGunBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemsViewHolder(viewBinding, itemsListener)
    }

    override fun onBindViewHolder(holder: ItemsViewHolder, position: Int) {
        holder.bind(listItems[position])
    }

    override fun getItemCount(): Int {
        return listItems.size
    }

}