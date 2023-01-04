package com.example.androidhomework.presentation.view.adapter.view

interface MainView {

    fun userExistsResult(userExists: Boolean, userViewOnBoarding: Boolean)

    fun userViewOnBoardingResult(userViewOnBoarding: Boolean)
}