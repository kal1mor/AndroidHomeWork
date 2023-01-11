package com.example.androidhomework.presentation.view.adapter.view.home.items

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidhomework.R
import com.example.androidhomework.domain.auth.AuthInteractor
import com.example.androidhomework.domain.items.ItemsInteractor
import com.example.androidhomework.domain.model.ItemsModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ItemsViewModel @Inject constructor(
    private val itemsInteractor: ItemsInteractor
): ViewModel() {

    private val _items = MutableLiveData<List<ItemsModel>>()
    val items: LiveData<List<ItemsModel>> = _items

    private val _message = MutableLiveData<Int>()
    val message: LiveData<Int> = _message

    private val _bundle = MutableLiveData<NavigateWithBundle?>()
    val bundle: LiveData<NavigateWithBundle?> = _bundle


    fun getData() {
        viewModelScope.launch {
            try {
                val listItems = itemsInteractor.getData()
                _items.value = listItems
            } catch (e: Exception) {
                Log.w("exception", "items not found")
            }
        }

    }

    fun imageViewClicked() {
        viewModelScope.launch {
            try {
                _message.value = R.string.image_view_clicked
            } catch (e: Exception) {
                Log.w("exception", "image not clicked")
            }
        }
    }

    fun elementClicked(name: String, date: String, imageView: Int) {
        viewModelScope.launch {
            try {
                _bundle.value = NavigateWithBundle(
                    name = name,
                    date = date,
                    image = imageView
                )
            } catch (e: Exception) {
                Log.w("exception", "element not clicked")
            }
        }
    }

    fun userNavigated() {
        viewModelScope.launch {
            try {
                _bundle.value = null
            } catch (e: Exception) {
                Log.w("exception", "user not navigate")
            }
        }
    }
}

data class NavigateWithBundle(
    val image: Int,
    val name: String,
    val date: String
)
