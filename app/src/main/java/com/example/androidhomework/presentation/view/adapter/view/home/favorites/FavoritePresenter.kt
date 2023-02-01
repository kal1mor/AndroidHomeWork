package com.example.androidhomework.presentation.view.adapter.view.home.favorites

import android.util.Log
import com.example.androidhomework.domain.items.ItemsInteractor
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class FavoritePresenter @Inject constructor(
    private val itemsInteractor: ItemsInteractor
){
    private lateinit var favoritesView: FavoriteView

    private val coroutineExceptionHandler = CoroutineExceptionHandler{ _, exception ->
        Log.w("Favorites exceptionHandlerCalled", exception.toString())
    }

    fun setView(context: FavoriteView){
        favoritesView = context
    }

    fun getFavorites(){
        CoroutineScope(coroutineExceptionHandler + Dispatchers.Main).launch {
            try {
                val job = launch {
                    val favoritesItems = itemsInteractor.getFavorites()
                    favoritesItems.collect{
                        favoritesView.favReceived(it)
                    }

                }
                job.join()
                job.cancel()
            } catch (e: Exception){
                Log.w("exception","getFavorites FAILED")
            }
        }
    }

    fun onDeleteClicked(id: Int){
        CoroutineScope(Dispatchers.Main).launch {
            try {
                val job = launch {
                    itemsInteractor.deleteFavById(id)
                }
                job.join()
                job.cancel()
            }catch (e: Exception){
                Log.w("exception", e.toString())
            }
        }
    }
}