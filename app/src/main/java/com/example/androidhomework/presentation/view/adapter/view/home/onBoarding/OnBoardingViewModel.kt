package com.example.androidhomework.presentation.view.adapter.view.home.onBoarding

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidhomework.R
import com.example.androidhomework.domain.auth.AuthInteractor
import com.example.androidhomework.domain.model.UserModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnBoardingViewModel @Inject constructor(
    private val authInteractor: AuthInteractor
): ViewModel(){

    private val _nav = MutableLiveData<Int?>()
    val nav : LiveData<Int?> = _nav


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

    fun userViewOnBoarding(){

        viewModelScope.launch {
            try {
                val doesUserViewOnBoarding = authInteractor.checkOnBoardingView()
                _nav.value = if (doesUserViewOnBoarding){
                    R.id.action_onBoardingFragment_to_itemsFragment
                }else{
                    Log.w("onBoarding", "onBoarding has not been viewed")
                }

            } catch (e: Exception) {
                Log.w("exception", "kay not sent ")
            }
        }
    }
}