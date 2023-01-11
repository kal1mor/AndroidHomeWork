package com.example.androidhomework.presentation.view.adapter.view.auth.onBoarding

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidhomework.domain.auth.AuthInteractor
import com.example.androidhomework.domain.model.UserModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnBoardingViewModel @Inject constructor(
    private val authInteractor: AuthInteractor
): ViewModel(){

    private val _nav = MutableLiveData<Unit?>()
    val nav : LiveData<Unit?> = _nav

    val onBoardingText = MutableLiveData<String>("default value")

    fun finishButtonClicked(){
        _nav.value = Unit
    }

    fun finishPerformed(){
        _nav.value = null
    }

    fun viewOnBoarding(key: String){
        viewModelScope.launch {
            try {
                authInteractor.viewOnBoarding(key)
            }catch (e: Exception){
                Log.w("exception", "kay not sent ")
            }

        }

    }
}