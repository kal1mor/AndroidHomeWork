package com.example.androidhomework.presentation.view.adapter.view.auth.login

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidhomework.R
import com.example.androidhomework.domain.auth.AuthInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val authInteractor: AuthInteractor
): ViewModel() {

    private val _nav = MutableLiveData<Unit?>()
    val nav: LiveData<Unit?> get() = _nav

    private val _userViewOnBoarding = MutableLiveData<Int?>()
    val userViewOnBoarding: LiveData<Int?> get() = _userViewOnBoarding

    private val _key = MutableLiveData<Int>()
    val key: LiveData<Int?> get() = _key


    fun loginUser(userName: String, userPassword: String) {
        viewModelScope.launch {
            try {
                val doesUserViewOnBoarding = authInteractor.checkOnBoardingView()
                authInteractor.loginUser(userName, userPassword)
                _nav.value = Unit
                when(doesUserViewOnBoarding) {
                    true -> {
                        _userViewOnBoarding.value = R.navigation.main_graph
                        _key.value = 1
                    }
                    false -> {
                        _userViewOnBoarding.value = R.id.action_logInFragment_to_onBoardingFragment
                        _key.value = 2
                    }
                }
            }catch (e: Exception){
                Log.w("exception", " user not logged")
            }

        }

    }

    fun userNavigated(){
        _nav.value = null
    }
}