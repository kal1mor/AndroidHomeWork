package com.example.androidhomework.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.androidhomework.data.database.ItemsEntity

@Dao
interface ItemsDao {
    @Insert
    fun insertItemsEntity(itemsEntity: ItemsEntity)

    @Query("SELECT (SELECT COUNT(*) FROM ItemsEntity) !=0")
    fun doesItemsEntityExist(): Boolean

    @Query("SELECT * FROM ItemsEntity")
    fun getItemsEntities(): List<ItemsEntity>
}