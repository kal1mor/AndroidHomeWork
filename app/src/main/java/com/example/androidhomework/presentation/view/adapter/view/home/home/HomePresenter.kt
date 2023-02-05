package com.example.androidhomework.presentation.view.adapter.view.home.home

import android.util.Log
import com.example.androidhomework.domain.items.ItemsInteractor
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomePresenter @Inject constructor(private val itemsInteractor: ItemsInteractor) {

    private lateinit var homeView: HomeView

    fun setView(context: HomeView) {
        homeView = context
    }

    fun getData() {
        CoroutineScope(Dispatchers.Main).launch {
            val job = launch {
                try {
                    val listItems = itemsInteractor.getHomeItems()
                    listItems.collect{
                        homeView.dataReceived(it)
                    }

                }catch (e: Exception) {
                    Log.w("exception", "data not found")
                }
            }
            job.join()
            job.cancel()
        }
    }
}