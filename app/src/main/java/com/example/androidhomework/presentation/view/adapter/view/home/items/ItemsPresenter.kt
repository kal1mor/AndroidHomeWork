package com.example.androidhomework.presentation.view.adapter.view.home.items

import android.util.Log
import com.example.androidhomework.R
import com.example.androidhomework.domain.items.ItemsInteractor
import io.reactivex.disposables.CompositeDisposable
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class ItemsPresenter @Inject constructor(private val itemsInteractor: ItemsInteractor) {

    private lateinit var itemsView: ItemsView

    private val compositeDisposable = CompositeDisposable()

    fun setView(context: ItemsView) {
        itemsView = context
    }

    fun getData() {
        val getData = itemsInteractor.getData().subscribe({

        },{

        })
        compositeDisposable.add(getData)

        val showData = itemsInteractor.showData().subscribe({
            itemsView.dataReceived(it)
        },{

        })
        compositeDisposable.add(showData)
    }

    fun elementSelected(name: String, username: String, email: String){
        itemsView.goToDetails(name, username, email)
    }

    fun onFavClicked(id: Int){
        CoroutineScope(Dispatchers.Main).launch {
            try {
                val job = launch {
                    itemsInteractor.onFavClicked(id)
                }
                job.join()
                job.cancel()
            } catch (e: Exception){
                Log.w("exception","onFavClicked FAILED")
            }
        }

    }

    fun onDeleteClicked(id: Int){
        CoroutineScope(Dispatchers.Main).launch {
            try {
                val job = launch {
                    itemsInteractor.deleteItemById(id)
                }
                job.join()
                job.cancel()
            }catch (e: Exception){
                Log.w("exception", e.toString())
            }
        }
    }

    fun updateFavorite(favorite: Boolean, id: Int){
        CoroutineScope(Dispatchers.Main).launch {
            try {
                val job = launch {
                    itemsInteractor.updateFavorite(favorite, id)
                }
                job.join()
                job.cancel()
            } catch (e: Exception){
                Log.w("exception","updateFav FAILED")
            }
        }
    }
}