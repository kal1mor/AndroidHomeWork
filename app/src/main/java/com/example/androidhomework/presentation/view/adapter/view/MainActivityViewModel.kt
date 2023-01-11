package com.example.androidhomework.presentation.view.adapter.view

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidhomework.domain.auth.AuthInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val authInteractor: AuthInteractor
) : ViewModel() {

    private val _userExist = MutableLiveData<Boolean>()
    val userExist: LiveData<Boolean> = _userExist

    private val _userViewOnBoarding = MutableLiveData<Boolean>()
    val userViewOnBoarding: LiveData<Boolean> = _userViewOnBoarding

    fun checkUserExist() {
        viewModelScope.launch {
            try {
                _userExist.value = authInteractor.cheackUserExist()
            }catch (e: Exception){
                Log.w("exception", "loginUser Failed")
            }

        }
    }

    fun checkUserViewOnBoarding() {
        viewModelScope.launch {
            try {
            _userViewOnBoarding.value = authInteractor.checkOnBoardingView()
        }catch (e: Exception){
                Log.w("exception", "User do not view OnBoarding")
        }
        }
    }
}

