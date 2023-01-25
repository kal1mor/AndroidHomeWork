package com.example.androidhomework.domain.items

import com.example.androidhomework.domain.model.ItemsModel

interface ItemsRepository {
    suspend fun getData()

    suspend fun showData(): List<ItemsModel>
}