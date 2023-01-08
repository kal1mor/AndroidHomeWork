package com.example.androidhomework.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.androidhomework.domain.items.ItemsInteractor
import com.example.androidhomework.presentation.view.adapter.view.home.items.ItemsViewModel

class ItemsViewModelFactory(
    private val itemsInteractor: ItemsInteractor
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ItemsViewModel(itemsInteractor) as T
    }
}