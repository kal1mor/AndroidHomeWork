package com.example.androidhomework.presentation.view.adapter.view.home.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androidhomework.domain.auth.AuthInteractor
import com.example.androidhomework.domain.items.ItemsInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val authInteractor: AuthInteractor
): ViewModel(){

    private val _nav = MutableLiveData<Unit?>()
    val nav: LiveData<Unit?> = _nav

    fun logoutUser(){
        authInteractor.logoutUser()
        _nav.value = Unit
    }
}