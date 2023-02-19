package com.example.androidhomework.domain.items

import com.example.androidhomework.di.FavoritesModel
import com.example.androidhomework.domain.model.HomeModel
import com.example.androidhomework.domain.model.ItemsModel
import io.reactivex.Completable
import io.reactivex.Observable
import kotlinx.coroutines.flow.Flow

interface ItemsRepository {
    fun getData():Completable

    fun getHomeData() :Completable

    fun showData(): Observable<List<ItemsModel>>

    suspend fun favClicked(itemsModel: ItemsModel)

    suspend fun deleteItemById(id: Int)

    suspend fun getFavorites(): Flow<List<FavoritesModel>>

    suspend fun findItemById(id: Int): ItemsModel

    suspend fun deleteFavById(id: Int)

    suspend fun getHomeItems(): Flow<List<HomeModel>>

    suspend fun updateFavorite(favorite: Boolean, id: Int)
}