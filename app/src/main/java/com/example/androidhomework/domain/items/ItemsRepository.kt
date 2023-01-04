package com.example.androidhomework.domain.items

import com.example.androidhomework.domain.model.ItemsModel

interface ItemsRepository {
    fun getData(): List<ItemsModel>
}