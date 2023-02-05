package com.example.androidhomework.presentation.view.adapter.view.home.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidhomework.databinding.ItemGunBinding
import com.example.androidhomework.databinding.ItemHomeBinding
import com.example.androidhomework.domain.model.HomeModel
import com.example.androidhomework.domain.model.ItemsModel
import com.example.androidhomework.presentation.view.adapter.view.home.items.adapter.ItemsListener
import com.example.androidhomework.presentation.view.adapter.view.home.items.adapter.ItemsViewHolder

class HomeAdapter(

): RecyclerView.Adapter<HomeViewHolder>() {

    private var listItems = mutableListOf<HomeModel>()

    fun submitList(list: List<HomeModel>){
        listItems.clear()
        listItems.addAll(list.toMutableList())
        this.notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val viewBinding = ItemHomeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        // val view = LayoutInflater.from(parent.context).inflate(R.layout.item_fruit, parent, false)
        return HomeViewHolder(viewBinding)
    }

    override fun getItemCount(): Int {
        return listItems.size
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bind(listItems[position])
    }
}