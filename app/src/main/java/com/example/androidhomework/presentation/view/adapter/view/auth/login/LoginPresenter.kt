package com.example.androidhomework.presentation.view.adapter.view.auth.login

import com.example.androidhomework.domain.auth.AuthInteractor
import javax.inject.Inject

class LoginPresenter @Inject constructor(
    private val authInteractor: AuthInteractor
) {
    private lateinit var loginView: LoginView

    fun setView(logInFragment: LogInFragment){
        loginView = logInFragment
    }

    fun loginUser(userName: String, userPassword: String){
        val doesUserViewOnBoarding = authInteractor.checkOnBoardingView()
        authInteractor.loginUser(userName, userPassword)
        loginView.userLoggedIn(doesUserViewOnBoarding)
    }
}