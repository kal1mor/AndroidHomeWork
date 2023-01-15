package com.example.androidhomework.presentation.view.adapter.view

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
class MainActivityViewModel @Inject constructor(
    private val authInteractor: AuthInteractor
) : ViewModel() {

    private val _userExist = MutableLiveData<Int?>()
    val userExist: LiveData<Int?> = _userExist

    private val _userViewOnBoarding = MutableLiveData<Boolean>()
    val userViewOnBoarding: LiveData<Boolean> = _userViewOnBoarding

    private val _key = MutableLiveData<Int>()
    val key: LiveData<Int?> get() = _key

    fun checkUserExist() {
        viewModelScope.launch {
            try {
                val doesUserExist = authInteractor.cheackUserExist()
                val doesUserViewOnBoarding = authInteractor.checkOnBoardingView()
                _userViewOnBoarding.value = doesUserViewOnBoarding
                _userExist.value = when(doesUserExist){
                    true -> {
                        when(doesUserViewOnBoarding){
                            true -> R.navigation.main_graph
                            false -> {
                                Log.w("6", "6")
                                R.id.action_logInFragment_to_onBoardingFragment
                            }
                        }
                    }
                    false -> R.navigation.auth_graph
                }
                 when(_userExist.value){
                    R.navigation.main_graph -> _key.value = 1
                    R.id.action_logInFragment_to_onBoardingFragment -> _key.value = 2
                    R.navigation.auth_graph -> _key.value = 3
                }

            } catch (e: Exception) {
                Log.w("exception", "loginUser Failed")
            }

        }
    }
}

