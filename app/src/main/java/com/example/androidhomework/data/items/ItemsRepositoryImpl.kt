package com.example.androidhomework.data.items

import android.util.Log
import com.example.androidhomework.R
import com.example.androidhomework.data.database.ItemsEntity
import com.example.androidhomework.data.database.dao.ItemsDao
import com.example.androidhomework.data.service.ApiService
import com.example.androidhomework.domain.items.ItemsRepository
import com.example.androidhomework.domain.model.ItemsModel
import kotlinx.coroutines.Dispatchers
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
                            it.address.geo.lng)
                        itemsDao.insertItemsEntity(itemsEntity)
                    }
                }
            }
        }
    }

    override suspend fun showData(): List<ItemsModel> {
        return withContext(Dispatchers.IO) {
            val itemsEntity = itemsDao.getItemsEntities()
            itemsEntity.map {
                ItemsModel(it.id,
                    it.name,
                    it.username,
                    it.email,
                    it.phone,
                    it.website,
                    it.street,
                    it.suite,
                    it.city,
                    it.zipcode,
                    it.name,
                    it.catchPhrase,
                    it.bs,
                    it.lat,
                    it.lng)
            }
        }
    }
}