package com.example.androidhomework.presentation.view.adapter.view.home.items.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.androidhomework.databinding.ItemGunBinding
import com.example.androidhomework.domain.model.ItemsModel

class ItemsViewHolder(
    private val viewBinding: ItemGunBinding,
    private val itemsListener: ItemsListener
    ): RecyclerView.ViewHolder(viewBinding.root) {

    fun bind(itemsModel: ItemsModel){
        viewBinding.tvName.text = "Name: " + itemsModel.name
        viewBinding.tvUsername.text = "Username: " + itemsModel.username
        viewBinding.tvEmail.text = "E-mail: " + itemsModel.email
        viewBinding.tvPhone.text = "Phone: " + itemsModel.phone
        viewBinding.tvAddress.text = "Address: " + itemsModel.city + ", " + itemsModel.street + "str., " + itemsModel.suite
        viewBinding.tvZipcode.text = "Zipcode: " + itemsModel.zipcode
        viewBinding.tvCompany.text = "Company: " + itemsModel.nameCompany
        viewBinding.tvGeo.text = "Geolocation: lat: " + itemsModel.lat+ ", lng: " + itemsModel.lng
        viewBinding.tvWebsite.text = "Website " + itemsModel.website
        viewBinding.tvBs.text = "Business: " + itemsModel.bs
        viewBinding.tvCatchPhrase.text = "Catch phrase: " + itemsModel.catchPhrase


        itemView.setOnClickListener{
            itemsListener.onElementSelected(
                itemsModel.name,
                itemsModel.username,
                itemsModel.email)
        }

        viewBinding.btnFav.setOnClickListener{
            itemsListener.onFavClicked(itemsModel.id)
        }

        viewBinding.btnDelete.setOnClickListener{
            itemsListener.onDeleteClicked(itemsModel.id)
        }

    }
}