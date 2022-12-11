package com.example.androidhomework.presentation.view

import com.example.androidhomework.R
import com.example.androidhomework.domain.ItemsInteractor

class ItemsPresenter(private val itemsView: ItemsView,
                     private val itemsInteractor: ItemsInteractor
) {

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