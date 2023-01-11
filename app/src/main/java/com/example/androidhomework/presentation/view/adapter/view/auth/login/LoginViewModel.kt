package com.example.androidhomework.presentation.view.adapter.view.auth.login

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidhomework.domain.auth.AuthInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val authInteractor: AuthInteractor
): ViewModel() {

    private val _nav = MutableLiveData<Unit?>()
    val nav: LiveData<Unit?> get() = _nav

    private val _userViewOnBoarding = MutableLiveData<Boolean>()
    val userViewOnBoarding: LiveData<Boolean?> get() = _userViewOnBoarding


    fun loginUser(userName: String, userPassword: String) {
        viewModelScope.launch {
            try {
                val doesUserViewOnBoarding = authInteractor.checkOnBoardingView()
                authInteractor.loginUser(userName, userPassword)
                _nav.value = Unit
                _userViewOnBoarding.value = doesUserViewOnBoarding
            }catch (e: Exception){}
            Log.w("exception", " user not logged")
        }

    }
}