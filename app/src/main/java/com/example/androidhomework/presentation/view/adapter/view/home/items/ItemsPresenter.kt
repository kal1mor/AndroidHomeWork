package com.example.androidhomework.presentation.view.adapter.view.home.items

import android.util.Log
import com.example.androidhomework.R
import com.example.androidhomework.domain.items.ItemsInteractor
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class ItemsPresenter @Inject constructor(private val itemsInteractor: ItemsInteractor) {

    private lateinit var itemsView: ItemsView

    fun setView(context: ItemsView) {
        itemsView = context
    }

    fun getData() {
        CoroutineScope(Dispatchers.Main).launch {
            val job = launch {
                try {
                    val listItems = itemsInteractor.getData()
                    itemsView.dataReceived(listItems)
                } catch (e: Exception) {
                    Log.w("exception", "data not found")
                }
            }
            job.join()
            job.cancel()
        }
    }

    fun imageViewCLicked() {
        itemsView.imageViewCLicked(R.string.image_view_clicked)
    }

    fun elementSelected(name: String, date: String, imageView: Int) {
        itemsView.goToDetails(name, date, imageView)
    }

}