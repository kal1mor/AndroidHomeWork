package com.example.androidhomework.presentation.view.adapter.view.home.items

import com.example.androidhomework.domain.model.ItemsModel

interface ItemsView {

    fun dataReceived(list: List<ItemsModel>)

    fun imageViewCLicked(msg: Int)

    fun goToDetails(name: String, date: String, imageView: Int)
}