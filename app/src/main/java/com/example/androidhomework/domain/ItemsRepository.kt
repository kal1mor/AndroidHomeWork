package com.example.androidhomework.domain

import com.example.androidhomework.model.ItemsModel

interface ItemsRepository {
    fun getData(): List<ItemsModel>
}