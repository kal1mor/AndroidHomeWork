package com.example.androidhomework

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ItemsViewMain: ViewModel() {

    private val _main = MutableLiveData<Int>()
    val main: LiveData<Int> = _main

    fun getMainId(){
        _main.value = R.id.activity_container
    }
}