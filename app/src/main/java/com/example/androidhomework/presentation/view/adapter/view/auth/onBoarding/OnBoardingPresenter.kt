package com.example.androidhomework.presentation.view.adapter.view.auth.onBoarding

import android.util.Log
import com.example.androidhomework.domain.auth.AuthInteractor
import com.example.androidhomework.presentation.view.adapter.view.auth.login.LogInFragment
import com.example.androidhomework.presentation.view.adapter.view.auth.login.LoginView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class OnBoardingPresenter @Inject constructor(
    private val authInteractor: AuthInteractor
) {

    private lateinit var onBoardingView: OnBoardingView

    fun setView(onBoardingFragment: OnBoardingFragment) {
        onBoardingView = onBoardingFragment
    }

    fun viewOnBoarding(key: String) {
        CoroutineScope(Dispatchers.Main).launch {
            val job = launch {
                try {
                    authInteractor.viewOnBoarding(key)
                    onBoardingView.userViewOnBoarding()
                } catch (e: Exception) {
                    Log.w("exception", "user not view onBoarding")
                }
            }
            job.join()
            job.cancel()
        }
    }
}