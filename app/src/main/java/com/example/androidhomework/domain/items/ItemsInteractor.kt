package com.example.androidhomework.domain.items

import com.example.androidhomework.domain.model.ItemsModel
import javax.inject.Inject

class ItemsInteractor @Inject constructor(private val itemsRepository: ItemsRepository) {

    suspend fun getData(): List<ItemsModel>{
        return itemsRepository.getData()
    }
}