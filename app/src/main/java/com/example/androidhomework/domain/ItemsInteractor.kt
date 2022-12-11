package com.example.androidhomework.domain

import com.example.androidhomework.model.ItemsModel

class ItemsInteractor(private val itemsRepository: ItemsRepository) {

    fun getData(): List<ItemsModel>{
        return itemsRepository.getData()
    }
}