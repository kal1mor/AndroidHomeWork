package com.example.androidhomework.presentation.view.adapter.view.auth.onBoarding

import com.example.androidhomework.domain.auth.AuthInteractor
import com.example.androidhomework.presentation.view.adapter.view.auth.login.LogInFragment
import com.example.androidhomework.presentation.view.adapter.view.auth.login.LoginView
import javax.inject.Inject

class OnBoardingPresenter @Inject constructor(
    private val authInteractor: AuthInteractor) {

    private lateinit var onBoardingView: OnBoardingView

    fun setView(onBoardingFragment: OnBoardingFragment){
            onBoardingView = onBoardingFragment
    }

    fun viewOnBoarding(key: String){
        authInteractor.viewOnBoarding(key)
        onBoardingView.userViewOnBoarding()
    }
}