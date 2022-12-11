package com.example.androidhomework.presentation.view

import com.example.androidhomework.model.ItemsModel

interface ItemsView {

    fun dataReceived(list: List<ItemsModel>)

    fun imageViewCLicked(msg: Int)

    fun goToDetails(name: String, date: String, imageView: Int)
}