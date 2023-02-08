package com.example.androidhomework.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.IGNORE
import androidx.room.Query
import com.example.androidhomework.data.database.FavoritesEntity
import com.example.androidhomework.data.database.HomeEntity
import com.example.androidhomework.data.database.ItemsEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ItemsDao {
    @Insert
    fun insertItemsEntity(itemsEntity: ItemsEntity)

    @Query("SELECT (SELECT COUNT(*) FROM ItemsEntity) !=0")
    fun doesItemsEntityExist(): Boolean

    @Query("SELECT * FROM ItemsEntity")
    fun getItemsEntities(): Flow<List<ItemsEntity>>

    @Query("DELETE FROM ItemsEntity WHERE id =:id")
    fun deleteItemEntityById(id: Int)

    @Query("DELETE FROM FavoritesEntity WHERE id =:id")
    fun deleteFavEntityById(id: Int)

    @Query("SELECT * FROM ItemsEntity WHERE id =:id")
    fun findItemEntityById(id: Int): ItemsEntity

    @Insert(onConflict = IGNORE)  // ignore when conflict occurs (ignore items if same)
    fun insetFavoritesEntity(favoritesEntity: FavoritesEntity)

    @Query("SELECT * FROM FavoritesEntity")
    fun getFavoritesEntities(): Flow<List<FavoritesEntity>>

    @Insert
    fun insertHomeEntity(homeEntity: HomeEntity)

    @Query("SELECT * FROM HomeEntity")
    fun getHomeEntities(): Flow<List<HomeEntity>>

    @Query("UPDATE ItemsEntity SET favorite=:favorite WHERE id =:id")
    fun updateFavorite(favorite: Boolean, id: Int)
}