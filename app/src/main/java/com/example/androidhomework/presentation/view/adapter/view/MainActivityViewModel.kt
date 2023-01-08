package com.example.androidhomework.presentation.view.adapter.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androidhomework.domain.auth.AuthInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val authInteractor: AuthInteractor
): ViewModel() {

    private val _userExist = MutableLiveData<Boolean>()
    val userExist: LiveData<Boolean> = _userExist

    private val _userViewOnBoarding = MutableLiveData<Boolean>()
    val userViewOnBoarding: LiveData<Boolean> = _userViewOnBoarding

    fun checkUserExist(){
        _userExist.value = authInteractor.cheackUserExist()
        _userExist.value = authInteractor.checkOnBoardingView()
    }

    fun checkUserViewOnBoarding(){
        _userViewOnBoarding.value = authInteractor.checkOnBoardingView()
    }

}