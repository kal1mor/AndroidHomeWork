package com.example.androidhomework.domain.items

import com.example.androidhomework.di.FavoritesModel
import com.example.androidhomework.domain.model.ItemsModel

interface ItemsRepository {
    suspend fun getData()

    suspend fun showData(): List<ItemsModel>

    suspend fun favClicked(itemsModel: ItemsModel)

    suspend fun deleteItemById(id: Int)

    suspend fun getFavorites(): List<FavoritesModel>

    suspend fun findItemById(id: Int): ItemsModel

}