package com.example.androidhomework.presentation.view.adapter.view.home.favorites

import com.example.androidhomework.di.FavoritesModel

interface FavoriteView {

    fun favReceived (list: List<FavoritesModel>)

    fun onDeleteClicked(id: Int)
}