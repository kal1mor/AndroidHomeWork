package com.example.androidhomework.presentation.view.adapter.view.home.favorites.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidhomework.databinding.ItemsFavoriteBinding
import com.example.androidhomework.di.FavoritesModel
import com.example.androidhomework.presentation.view.adapter.view.home.favorites.FavoritesFragment

class FavoriteAdapter(
    private val favoriteListener: FavoriteListener
        ): RecyclerView.Adapter<FavoriteViewHolder>() {

    private var listItems = mutableListOf<FavoritesModel>()


    fun submitList(list: List<FavoritesModel>){
        this.listItems.clear()
        this.listItems = list.toMutableList()
        this.notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
        val view = ItemsFavoriteBinding.inflate(LayoutInflater.from(parent.context),
            parent,
            false)
        return FavoriteViewHolder(view, favoriteListener)
    }

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
        holder.bind(listItems[position])
    }

    override fun getItemCount(): Int {
        return listItems.size //or 0
    }
}