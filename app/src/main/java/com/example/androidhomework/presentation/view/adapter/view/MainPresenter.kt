package com.example.androidhomework.presentation.view.adapter.view

import com.example.androidhomework.domain.auth.AuthInteractor
import javax.inject.Inject

class MainPresenter@Inject constructor(
    private val authInteractor: AuthInteractor
) {

    private lateinit var mainView: MainView

    fun setView(mainActivity: MainActivity){
        mainView = mainActivity
    }


    fun checkUserExist(){
        val doesUserExist = authInteractor.cheackUserExist()
        val doesUserViewOnBoarding = authInteractor.checkOnBoardingView()
        mainView.userExistsResult(doesUserExist, doesUserViewOnBoarding)



    }

    fun checkUserViewOnBoarding(){
        val doesUserViewOnBoarding = authInteractor.checkOnBoardingView()
        mainView.userViewOnBoardingResult(doesUserViewOnBoarding)
    }
}