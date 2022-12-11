package com.example.androidhomework.presentation.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androidhomework.R

class ItemsViewMain: ViewModel() {


    private val _main = MutableLiveData<Int>()
    val main: LiveData<Int> = _main

    fun getMainId(){
        _main.value = R.id.activity_container
    }
}