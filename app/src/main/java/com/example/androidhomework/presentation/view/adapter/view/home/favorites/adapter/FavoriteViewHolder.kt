package com.example.androidhomework.presentation.view.adapter.view.home.favorites.adapter

import android.annotation.SuppressLint
import androidx.recyclerview.widget.RecyclerView
import com.example.androidhomework.databinding.ItemsFavoriteBinding
import com.example.androidhomework.di.FavoritesModel

class FavoriteViewHolder(
    private val viewBinding: ItemsFavoriteBinding
) : RecyclerView.ViewHolder(viewBinding.root) {

    @SuppressLint("SetTextI18n")
    fun bind(favItems: FavoritesModel) {

        viewBinding.tvName.text = "Name: " + favItems.name
        viewBinding.tvUsername.text = "Username: " + favItems.username
        viewBinding.tvEmail.text = "E-mail: " + favItems.email
        viewBinding.tvPhone.text = "Phone: " + favItems.phone
        viewBinding.tvAddress.text = "Address: " + favItems.city + ", " + favItems.street + "str., " + favItems.suite
        viewBinding.tvZipcode.text = "Zipcode: " + favItems.zipcode
        viewBinding.tvCompany.text = "Company: " + favItems.nameCompany
        viewBinding.tvGeo.text = "Geolocation: lat: " + favItems.lat+ ", lng: " + favItems.lng
        viewBinding.tvWebsite.text = "Website " + favItems.website
        viewBinding.tvBs.text = "Business: " + favItems.bs
        viewBinding.tvCatchPhrase.text = "Catch phrase: " + favItems.catchPhrase
    }
}