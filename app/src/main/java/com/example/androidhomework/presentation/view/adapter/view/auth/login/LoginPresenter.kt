package com.example.androidhomework.presentation.view.adapter.view.auth.login

import android.util.Log
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.lifecycleScope
import com.example.androidhomework.domain.auth.AuthInteractor
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch


import javax.inject.Inject

class LoginPresenter @Inject constructor(
    private val authInteractor: AuthInteractor
) {
    private lateinit var loginView: LoginView

    fun setView(logInFragment: LogInFragment) {
        loginView = logInFragment
    }

    fun loginUser(userName: String, userPassword: String) {
        CoroutineScope(Dispatchers.Main).launch {
            val job = launch {
                try {
                    val doesUserViewOnBoarding = authInteractor.checkOnBoardingView()
                    authInteractor.loginUser(userName, userPassword)
                    loginView.userLoggedIn(doesUserViewOnBoarding)
                } catch (e: Exception) {
                    Log.w("exception", " user not logged")
                }
            }
            job.join()
            job.cancel()
        }
    }
}