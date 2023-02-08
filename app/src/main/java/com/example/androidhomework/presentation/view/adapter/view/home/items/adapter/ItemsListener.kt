package com.example.androidhomework.presentation.view.adapter.view.home.items.adapter

interface ItemsListener {

    fun onElementSelected(name: String, username: String, email: String)

    fun onFavClicked(id: Int)

    fun onDeleteClicked(id: Int)

    fun updateFavorite(favorite: Boolean, id: Int)
}