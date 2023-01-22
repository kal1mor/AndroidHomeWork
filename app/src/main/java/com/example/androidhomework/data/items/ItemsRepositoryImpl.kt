package com.example.androidhomework.data.items

import com.example.androidhomework.R
import com.example.androidhomework.data.service.ApiService
import com.example.androidhomework.domain.items.ItemsRepository
import com.example.androidhomework.domain.model.ItemsModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ItemsRepositoryImpl @Inject constructor(
    private val apiService: ApiService
): ItemsRepository {
    override suspend fun getData(): List<ItemsModel> {
        return withContext(Dispatchers.IO) {
            val response = apiService.getData()
            response.body()?.let {
                it.map {
                    ItemsModel(
                        it.id,
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
                    )
                }
            } ?: kotlin.run {
                emptyList()
            }
        }
    }
}