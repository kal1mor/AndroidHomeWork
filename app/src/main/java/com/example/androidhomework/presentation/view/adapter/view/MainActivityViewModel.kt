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

    private val _doesUserExist = MutableLiveData<Boolean?>()
    val doesUserExist: LiveData<Boolean?> = _doesUserExist


    fun checkUserExist() {
        viewModelScope.launch {
            try {
                val doesUserExist = authInteractor.cheackUserExist()

                when(doesUserExist){
                    true -> {
                        _userExist.value = R.navigation.main_graph
                        _doesUserExist.value = true
                    }
                    false -> {
                        _userExist.value = R.navigation.auth_graph
                        _doesUserExist.value = false
                    }
                }

            } catch (e: Exception) {
                Log.w("exception", "loginUser Failed")
            }

        }
    }
}

