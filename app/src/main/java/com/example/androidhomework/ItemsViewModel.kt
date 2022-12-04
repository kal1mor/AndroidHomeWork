package com.example.androidhomework

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androidhomework.model.ItemsModel

import kotlin.coroutines.coroutineContext

class ItemsViewModel: ViewModel() {

    private val _items = MutableLiveData<List<ItemsModel>>()
    val items: LiveData<List<ItemsModel>> = _items

    private val _message = MutableLiveData<String>()
    val message: LiveData<String> = _message

    private val _bundle = MutableLiveData<NavigateWithBundle>()
    val bundle: LiveData<NavigateWithBundle> = _bundle

    fun getData(){
        val listItems = listOf<ItemsModel>(
            ItemsModel(
                R.drawable.m4a1,
                "m4a1",
                "28.11.2022"
            ),
            ItemsModel(
                R.drawable.aug,
                "AUG",
                "27.11.2022"
            ),
            ItemsModel(
                R.drawable.awp,
                "AWP",
                "26.11.2022"
            ),
            ItemsModel(
                R.drawable.p2000,
                "p2000",
                "25.11.2022"
            ),
            ItemsModel(
                R.drawable.m4a1,
                "m4a1",
                "24.11.2022"
            ),
            ItemsModel(
                R.drawable.aug,
                "aug",
                "23.11.2022"
            ),
            ItemsModel(
                R.drawable.awp,
                "awp",
                "22.11.2022"
            ),
            ItemsModel(
                R.drawable.p2000,
                "p2000",
                "21.11.2022"
            ),
            ItemsModel(
                R.drawable.m4a1,
                "m4a1",
                "20.11.2022"
            ),
            ItemsModel(
                R.drawable.aug,
                "aug",
                "19.11.2022"
            ),
            ItemsModel(
                R.drawable.awp,
                "awp",
                "18.11.2022"
            ),
            ItemsModel(
                R.drawable.p2000,
                "p2000",
                "17.11.2022"
            ),
            ItemsModel(
                R.drawable.m4a1,
                "m4a1",
                "16.11.2022"
            ),
            ItemsModel(
                R.drawable.aug,
                "aug",
                "15.11.2022"
            )
        )
        _items.value = listItems
    }

    fun imageViewClicked() {
        _message.value = "ImageView clicked"
    }

    fun elementClicked(name: String, date: String, imageView: Int) {
        _bundle.value = NavigateWithBundle(
            name = name,
            date = date,
            image = imageView
        )
    }
}

data class NavigateWithBundle(
    val image: Int,
    val name: String,
    val date: String
)