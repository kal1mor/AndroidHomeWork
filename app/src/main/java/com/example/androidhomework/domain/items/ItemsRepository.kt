package com.example.androidhomework.domain.items

import com.example.androidhomework.di.FavoritesModel
import com.example.androidhomework.domain.model.HomeModel
import com.example.androidhomework.domain.model.ItemsModel
import kotlinx.coroutines.flow.Flow

interface ItemsRepository {
    suspend fun getData()

    suspend fun getHomeData()

    suspend fun showData(): Flow<List<ItemsModel>>

    suspend fun favClicked(itemsModel: ItemsModel)

    suspend fun deleteItemById(id: Int)

    suspend fun getFavorites(): Flow<List<FavoritesModel>>

    suspend fun findItemById(id: Int): ItemsModel

    suspend fun deleteFavById(id: Int)

    suspend fun getHomeItems(): Flow<List<HomeModel>>

    suspend fun updateFavorite(favorite: Boolean, id: Int)
}