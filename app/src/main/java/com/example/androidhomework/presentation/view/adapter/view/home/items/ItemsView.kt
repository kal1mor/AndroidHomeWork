package com.example.androidhomework.presentation.view.adapter.view.home.items

import com.example.androidhomework.domain.model.ItemsModel

interface ItemsView {

    fun dataReceived(list: List<ItemsModel>)

    fun goToDetails(name: String, username: String, email: String)

    fun onDeleteClicked(id: Int)
}