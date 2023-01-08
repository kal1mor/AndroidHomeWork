package com.example.androidhomework.presentation.view.adapter.view.auth.onBoarding

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androidhomework.domain.auth.AuthInteractor
import com.example.androidhomework.domain.model.UserModel
import dagger.hilt.android.lifecycle.HiltViewModel
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
        authInteractor.viewOnBoarding(key)

    }
}