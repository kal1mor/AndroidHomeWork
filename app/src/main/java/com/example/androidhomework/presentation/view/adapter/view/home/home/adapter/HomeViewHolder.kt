package com.example.androidhomework.presentation.view.adapter.view.home.home.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.androidhomework.databinding.ItemGunBinding
import com.example.androidhomework.databinding.ItemHomeBinding
import com.example.androidhomework.domain.model.HomeModel
import com.example.androidhomework.domain.model.ItemsModel
import com.example.androidhomework.presentation.view.adapter.view.home.items.adapter.ItemsListener

class HomeViewHolder(
    private val viewBinding: ItemHomeBinding,
): RecyclerView.ViewHolder(viewBinding.root) {

    fun bind(homeModel: HomeModel){
        viewBinding.tvName.text = "Name: " + homeModel.name
        viewBinding.tvUsername.text = "Username: " + homeModel.username
        viewBinding.tvEmail.text = "E-mail: " + homeModel.email
        viewBinding.tvPhone.text = "Phone: " + homeModel.phone
        viewBinding.tvAddress.text = "Address: " + homeModel.city + ", " + homeModel.street + "str., " + homeModel.suite
        viewBinding.tvZipcode.text = "Zipcode: " + homeModel.zipcode
        viewBinding.tvCompany.text = "Company: " + homeModel.nameCompany
        viewBinding.tvGeo.text = "Geolocation: lat: " + homeModel.lat+ ", lng: " + homeModel.lng
        viewBinding.tvWebsite.text = "Website " + homeModel.website
        viewBinding.tvBs.text = "Business: " + homeModel.bs
        viewBinding.tvCatchPhrase.text = "Catch phrase: " + homeModel.catchPhrase

    }
}