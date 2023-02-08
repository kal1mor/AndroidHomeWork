package com.example.androidhomework.data.items

import android.util.Log
import com.example.androidhomework.data.database.FavoritesEntity
import com.example.androidhomework.data.database.HomeEntity
import com.example.androidhomework.data.database.ItemsEntity
import com.example.androidhomework.data.database.dao.ItemsDao
import com.example.androidhomework.data.service.ApiService
import com.example.androidhomework.di.FavoritesModel
import com.example.androidhomework.domain.items.ItemsRepository
import com.example.androidhomework.domain.model.HomeModel
import com.example.androidhomework.domain.model.ItemsModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ItemsRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val itemsDao: ItemsDao
): ItemsRepository {
    override suspend fun getData() {
        return withContext(Dispatchers.IO) {

            if (!itemsDao.doesItemsEntityExist()){
                Log.w("getData", "data not exists")
                val response = apiService.getData()

                response.body()?.let {
                    it.map {
                        val itemsEntity = ItemsEntity(it.id,
                            it.name,
                            it.username,
                            it.email,
                            it.phone,
                            it.website,
                            it.address.street,
                            it.address.suite,
                            it.address.city,
                            it.address.zipcode,
                            it.company.name,
                            it.company.catchPhrase,
                            it.company.bs,
                            it.address.geo.lat,
                            it.address.geo.lng,
                            !it.favorite)
                        itemsDao.insertItemsEntity(itemsEntity)
                    }
                }
            }
        }
    }

    override suspend fun getHomeData() {
        return withContext(Dispatchers.IO) {

            if (!itemsDao.doesItemsEntityExist()){
                Log.w("getData", "data not exists")
                val response = apiService.getData()

                response.body()?.let {
                    it.map {
                        val homeEntity = HomeEntity(it.id,
                            it.name,
                            it.username,
                            it.email,
                            it.phone,
                            it.website,
                            it.address.street,
                            it.address.suite,
                            it.address.city,
                            it.address.zipcode,
                            it.company.name,
                            it.company.catchPhrase,
                            it.company.bs,
                            it.address.geo.lat,
                            it.address.geo.lng)
                        itemsDao.insertHomeEntity(homeEntity)
                    }
                }
            }
        }
    }

    override suspend fun showData(): Flow<List<ItemsModel>> {
        return withContext(Dispatchers.IO) {
        val itemsEntity = itemsDao.getItemsEntities()
            itemsEntity.map { itemsList ->
                itemsList.map { item ->
                    ItemsModel(
                        item.id,
                        item.name,
                        item.username,
                        item.email,
                        item.phone,
                        item.website,
                        item.street,
                        item.suite,
                        item.city,
                        item.zipcode,
                        item.name,
                        item.catchPhrase,
                        item.bs,
                        item.lat,
                        item.lng,
                        item.favorite
                    )
                }
            }
        }
    }

    override suspend fun favClicked(itemsModel: ItemsModel) {
        return withContext(Dispatchers.IO){
            itemsDao.insetFavoritesEntity(
                FavoritesEntity(
                    itemsModel.id,
                    itemsModel.name,
                    itemsModel.username,
                    itemsModel.email,
                    itemsModel.phone,
                    itemsModel.website,
                    itemsModel.street,
                    itemsModel.suite,
                    itemsModel.city,
                    itemsModel.zipcode,
                    itemsModel.name,
                    itemsModel.catchPhrase,
                    itemsModel.bs,
                    itemsModel.lat,
                    itemsModel.lng,
                    itemsModel.favorite
                )
            )
        }
    }

    override suspend fun deleteItemById(id: Int) {
        withContext(Dispatchers.IO){
            itemsDao.deleteItemEntityById(id)
        }
    }


    override suspend fun getFavorites(): Flow<List<FavoritesModel>> {
        return withContext(Dispatchers.IO) {
            val favoritesEntity = itemsDao.getFavoritesEntities()
            favoritesEntity.map{ favList ->
                favList.map { favItem ->
                    FavoritesModel(
                        favItem.id,
                        favItem.name,
                        favItem.username,
                        favItem.email,
                        favItem.phone,
                        favItem.website,
                        favItem.street,
                        favItem.suite,
                        favItem.city,
                        favItem.zipcode,
                        favItem.nameCompany,
                        favItem.catchPhrase,
                        favItem.bs,
                        favItem.lat,
                        favItem.lng,
                        favItem.favorite
                    )
                }
            }
        }
    }

    override suspend fun findItemById(id: Int): ItemsModel {
        return withContext(Dispatchers.IO){
            val itemsEntity = itemsDao.findItemEntityById(id)
            ItemsModel(itemsEntity.id,
                itemsEntity.name,
                itemsEntity.username,
                itemsEntity.email,
                itemsEntity.phone,
                itemsEntity.website,
                itemsEntity.street,
                itemsEntity.suite,
                itemsEntity.city,
                itemsEntity.zipcode,
                itemsEntity.name,
                itemsEntity.catchPhrase,
                itemsEntity.bs,
                itemsEntity.lat,
                itemsEntity.lng,
                !itemsEntity.favorite)
        }
    }

    override suspend fun deleteFavById(id: Int) {
        withContext(Dispatchers.IO){
            itemsDao.deleteFavEntityById(id)
        }
    }

    override suspend fun getHomeItems(): Flow<List<HomeModel>> {
        return withContext(Dispatchers.IO) {
            val homeEntity = itemsDao.getHomeEntities()
            homeEntity.map{ favList ->
                favList.map { favItem ->
                    HomeModel(
                        favItem.id,
                        favItem.name,
                        favItem.username,
                        favItem.email,
                        favItem.phone,
                        favItem.website,
                        favItem.street,
                        favItem.suite,
                        favItem.city,
                        favItem.zipcode,
                        favItem.nameCompany,
                        favItem.catchPhrase,
                        favItem.bs,
                        favItem.lat,
                        favItem.lng
                    )
                }
            }
        }
    }

    override suspend fun updateFavorite(favorite: Boolean, id: Int) {
        return withContext(Dispatchers.IO) {
            itemsDao.updateFavorite(favorite, id)
        }
    }
}