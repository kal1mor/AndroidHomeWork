package com.example.androidhomework.data.items

import android.annotation.SuppressLint
import android.util.Log
import com.example.androidhomework.data.database.FavoritesEntity
import com.example.androidhomework.data.database.HomeEntity
import com.example.androidhomework.data.database.ItemsEntity
import com.example.androidhomework.data.database.dao.ItemsDao
import com.example.androidhomework.data.service.ApiService
import com.example.androidhomework.di.FavoritesModel
import com.example.androidhomework.domain.items.ItemsRepository
import com.example.androidhomework.domain.model.HomeModel
import com.example.androidhomework.domain.model.ItemsModel
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ItemsRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val itemsDao: ItemsDao
) : ItemsRepository {

    private val compositeDisposable = CompositeDisposable()

    @SuppressLint("CheckResult")
    override fun getData(): Completable {

        return itemsDao.doesItemsEntityExist()
            .subscribeOn(Schedulers.io())
            .doAfterNext {
                if (!it) {
                    val response = apiService.getData()
                    val getData = response.subscribeOn(Schedulers.io())
                        .doAfterSuccess {
                            .forEach {
                            val itemsEntity =
                                ItemsEntity(
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
                                    it.favorite
                                )
                            itemsDao.insertItemsEntity(itemsEntity)

                            }
                        }
                        .doOnError {
                            Log.w("error", "when making request")
                        }
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe()
                    compositeDisposable.add(getData)

                }
            }
            .doOnComplete {
                compositeDisposable.dispose()
            }
            .ignoreElements()
            .observeOn(AndroidSchedulers.mainThread())
    }

    @SuppressLint("CheckResult")
    override fun getHomeData(): Completable {
        return itemsDao.doesItemsEntityExist()
            .subscribeOn(Schedulers.io())
            .doAfterNext {
                if (!it) {
                    val response = apiService.getData()
                    val getData = response.subscribeOn(Schedulers.io())
                        .doAfterSuccess {
                            .forEach {
                            val homeEntity =
                                HomeEntity(
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
                                    it.address.geo.lng
                                )
                            itemsDao.insertHomeEntity(homeEntity)
                            }
                        }
                        .doOnError {
                            Log.w("error", "when making request")
                        }
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe()
                    compositeDisposable.add(getData)

                }
            }
            .doOnComplete {
                compositeDisposable.dispose()
            }
            .ignoreElements()
            .observeOn(AndroidSchedulers.mainThread())
    }

    override fun showData(): Observable<List<ItemsModel>> {
        val itemsEntity = itemsDao.getItemsEntities()
        return itemsEntity.subscribeOn(Schedulers.io())
            .map {
                it.map { item ->
                    ItemsModel(
                        item.id,
                        item.name,
                        item.username,
                        item.email,
                        item.phone,
                        item.website,
                        item.street,
                        item.suite,
                        item.city,
                        item.zipcode,
                        item.name,
                        item.catchPhrase,
                        item.bs,
                        item.lat,
                        item.lng,
                        item.favorite
                    )
                }
            }
            .observeOn(AndroidSchedulers.mainThread())
    }

    override suspend fun favClicked(itemsModel: ItemsModel) {
        return withContext(Dispatchers.IO) {
            itemsDao.insetFavoritesEntity(
                FavoritesEntity(
                    itemsModel.id,
                    itemsModel.name,
                    itemsModel.username,
                    itemsModel.email,
                    itemsModel.phone,
                    itemsModel.website,
                    itemsModel.street,
                    itemsModel.suite,
                    itemsModel.city,
                    itemsModel.zipcode,
                    itemsModel.name,
                    itemsModel.catchPhrase,
                    itemsModel.bs,
                    itemsModel.lat,
                    itemsModel.lng,
                    itemsModel.favorite
                )
            )
        }
    }

    override suspend fun deleteItemById(id: Int) {
        withContext(Dispatchers.IO) {
            itemsDao.deleteItemEntityById(id)
        }
    }


    override suspend fun getFavorites(): Flow<List<FavoritesModel>> {
        return withContext(Dispatchers.IO) {
            val favoritesEntity = itemsDao.getFavoritesEntities()
            favoritesEntity.map { favList ->
                favList.map { favItem ->
                    FavoritesModel(
                        favItem.id,
                        favItem.name,
                        favItem.username,
                        favItem.email,
                        favItem.phone,
                        favItem.website,
                        favItem.street,
                        favItem.suite,
                        favItem.city,
                        favItem.zipcode,
                        favItem.nameCompany,
                        favItem.catchPhrase,
                        favItem.bs,
                        favItem.lat,
                        favItem.lng,
                        favItem.favorite
                    )
                }
            }
        }
    }

    override suspend fun findItemById(id: Int): ItemsModel {
        return withContext(Dispatchers.IO) {
            val itemsEntity = itemsDao.findItemEntityById(id)
            ItemsModel(
                itemsEntity.id,
                itemsEntity.name,
                itemsEntity.username,
                itemsEntity.email,
                itemsEntity.phone,
                itemsEntity.website,
                itemsEntity.street,
                itemsEntity.suite,
                itemsEntity.city,
                itemsEntity.zipcode,
                itemsEntity.name,
                itemsEntity.catchPhrase,
                itemsEntity.bs,
                itemsEntity.lat,
                itemsEntity.lng,
                !itemsEntity.favorite
            )
        }
    }

    override suspend fun deleteFavById(id: Int) {
        withContext(Dispatchers.IO) {
            itemsDao.deleteFavEntityById(id)
        }
    }

    override suspend fun getHomeItems(): Flow<List<HomeModel>> {
        return withContext(Dispatchers.IO) {
            val homeEntity = itemsDao.getHomeEntities()
            homeEntity.map { favList ->
                favList.map { favItem ->
                    HomeModel(
                        favItem.id,
                        favItem.name,
                        favItem.username,
                        favItem.email,
                        favItem.phone,
                        favItem.website,
                        favItem.street,
                        favItem.suite,
                        favItem.city,
                        favItem.zipcode,
                        favItem.nameCompany,
                        favItem.catchPhrase,
                        favItem.bs,
                        favItem.lat,
                        favItem.lng
                    )
                }
            }
        }
    }

    override suspend fun updateFavorite(favorite: Boolean, id: Int) {
        return withContext(Dispatchers.IO) {
            itemsDao.updateFavorite(favorite, id)
        }
    }
}