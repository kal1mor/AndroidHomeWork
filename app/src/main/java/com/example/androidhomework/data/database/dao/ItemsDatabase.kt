package com.example.androidhomework.data.database.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.androidhomework.data.database.FavoritesEntity
import com.example.androidhomework.data.database.ItemsEntity

@Database(entities = [ItemsEntity::class, FavoritesEntity::class], version = 1, exportSchema = false)
abstract class ItemsDatabase: RoomDatabase() {

    abstract fun getItemsDAO(): ItemsDao

    companion object {
        private const val DB_NAME = "items_db"
        private var BD_INSTANCE: ItemsDatabase? = null

        fun getItemsDatabaseInstance(context: Context): ItemsDatabase {
            return BD_INSTANCE ?: Room
                .databaseBuilder(
                    context.applicationContext,
                    ItemsDatabase::class.java,
                    DB_NAME
                )
                .build()
                .also { BD_INSTANCE = it }
        }
    }
}