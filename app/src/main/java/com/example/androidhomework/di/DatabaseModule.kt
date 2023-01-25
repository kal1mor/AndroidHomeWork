package com.example.androidhomework.di

import android.content.Context
import com.example.androidhomework.data.database.dao.ItemsDao
import com.example.androidhomework.data.database.dao.ItemsDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    fun provideItemsDao(itemsDatabase: ItemsDatabase): ItemsDao {
        return itemsDatabase.getItemsDAO()

    }


    //Creating DataBase
    @Provides
    fun itemsDataBase(context: Context): ItemsDatabase{
        return ItemsDatabase.getItemsDatabaseInstance(context)

    }
}