package com.example.androidhomework.presentation.view.adapter.view.home.items

import android.util.Log
import com.example.androidhomework.R
import com.example.androidhomework.domain.items.ItemsInteractor
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class ItemsPresenter @Inject constructor(private val itemsInteractor: ItemsInteractor) {

    private lateinit var itemsView: ItemsView

    fun setView(context: ItemsView) {
        itemsView = context
    }

    fun getData() {
        CoroutineScope(Dispatchers.Main).launch {
            val jobShowData = launch {
                try {
                    val listItems = itemsInteractor.showData()
                        listItems.collect{
                            itemsView.dataReceived(it)
                    }
                }catch (e: Exception) {
                    Log.w("exception", "data not found")
                }
            }

            val job = launch {
                try {
                    itemsInteractor.getData()
                } catch (e: Exception) {
                    Log.w("exception", "data not found")
                }
            }
            jobShowData.join()
            job.join()
            jobShowData.cancel()
            job.cancel()
        }
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