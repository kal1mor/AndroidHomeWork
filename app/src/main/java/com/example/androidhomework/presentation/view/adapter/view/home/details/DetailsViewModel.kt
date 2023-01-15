package com.example.androidhomework.presentation.view.adapter.view.home.details

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidhomework.R
import com.example.androidhomework.domain.auth.AuthInteractor
import com.example.androidhomework.domain.items.ItemsInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val authInteractor: AuthInteractor
): ViewModel(){

    private val _nav = MutableLiveData<Int?>()
    val nav: LiveData<Int?> = _nav

    fun logoutUser(){
        viewModelScope.launch{
            try {
                authInteractor.logoutUser()
                _nav.value = R.navigation.auth_graph
            }catch (e: Exception){
                Log.w("exception", "user can not logout")
            }
        }

    }
}
