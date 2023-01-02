package com.example.androidhomework.presentation.view.adapter.view

import com.example.androidhomework.R
import com.example.androidhomework.domain.ItemsInteractor
import com.example.androidhomework.presentation.view.adapter.view.ItemsView
import javax.inject.Inject

class ItemsPresenter @Inject constructor(private val itemsInteractor: ItemsInteractor) {

    private lateinit var itemsView: ItemsView

    fun setView(context: ItemsView){
        itemsView = context
    }

    fun getData(){
        val listItems = itemsInteractor.getData()
        itemsView.dataReceived(listItems)

    }

    fun imageViewCLicked(){
        itemsView.imageViewCLicked(R.string.image_view_clicked)
    }

    fun elementSelected(name: String, date: String, imageView: Int){
        itemsView.goToDetails(name,date,imageView)
    }

}