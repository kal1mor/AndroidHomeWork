package com.example.androidhomework.presentation.view.adapter.view.home.items

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androidhomework.R
import com.example.androidhomework.domain.auth.AuthInteractor
import com.example.androidhomework.domain.items.ItemsInteractor
import com.example.androidhomework.domain.model.ItemsModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ItemsViewModel @Inject constructor(
    private val itemsInteractor: ItemsInteractor
): ViewModel(){

    private val _items = MutableLiveData<List<ItemsModel>>()
    val items: LiveData<List<ItemsModel>> = _items

    private val _message = MutableLiveData<Int>()
    val message: LiveData<Int> = _message

    private val _bundle = MutableLiveData<NavigateWithBundle?>()
    val bundle: LiveData<NavigateWithBundle?> = _bundle



    fun getData() {
        val listItems = itemsInteractor.getData()
        _items.value = listItems
    }

    fun imageViewClicked() {
        _message.value = R.string.image_view_clicked
    }

    fun elementClicked(name: String, date: String, imageView: Int) {
        _bundle.value = NavigateWithBundle(
            name = name,
            date = date,
            image = imageView
        )
    }

    fun userNavigated(){
        _bundle.value = null
    }

}

data class NavigateWithBundle(
    val image: Int,
    val name: String,
    val date: String
)
