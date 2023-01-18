package com.example.androidhomework.presentation.view.adapter.view

import android.util.Log
import com.example.androidhomework.domain.auth.AuthInteractor
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainPresenter @Inject constructor(
    private val authInteractor: AuthInteractor
) {

    private lateinit var mainView: MainView

    fun setView(mainActivity: MainActivity) {
        mainView = mainActivity
    }


    fun checkUserExist() {
        CoroutineScope(Dispatchers.Main).launch {
            val job = launch {
                try {
                    val doesUserExist = authInteractor.cheackUserExist()
                    val doesUserViewOnBoarding = authInteractor.checkOnBoardingView()
                    mainView.userExistsResult(doesUserExist, doesUserViewOnBoarding)
                } catch (e: Exception) {
                    Log.w("exception", "user not exists")
                }
            }
            job.join()
            job.cancel()
        }
    }
}