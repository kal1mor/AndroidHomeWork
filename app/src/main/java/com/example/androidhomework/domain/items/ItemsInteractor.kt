package com.example.androidhomework.domain.items

import com.example.androidhomework.di.FavoritesModel
import com.example.androidhomework.domain.model.HomeModel
import com.example.androidhomework.domain.model.ItemsModel
import io.reactivex.Completable
import io.reactivex.Observable
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ItemsInteractor @Inject constructor(private val itemsRepository: ItemsRepository) {

    fun getData():Completable{
        return itemsRepository.getData()
    }

    fun showData(): Observable<List<ItemsModel>>{
        return itemsRepository.showData()
    }

    suspend fun findItemById(id: Int): ItemsModel{
        return itemsRepository.findItemById(id)
    }

    suspend fun onFavClicked(id: Int){
        val foundItem = findItemById(id)
        itemsRepository.favClicked(foundItem)
    }

    suspend fun getFavorites(): Flow<List<FavoritesModel>>{
        return itemsRepository.getFavorites()
    }

    suspend fun deleteItemById(id: Int){
        itemsRepository.deleteItemById(id)
    }

    suspend fun deleteFavById(id: Int){
        itemsRepository.deleteFavById(id)
    }

    suspend fun getHomeItems(): Flow<List<HomeModel>>{
        return itemsRepository.getHomeItems()
    }

    suspend fun updateFavorite(favorite: Boolean, id: Int){
        return itemsRepository.updateFavorite(favorite, id)
    }
}