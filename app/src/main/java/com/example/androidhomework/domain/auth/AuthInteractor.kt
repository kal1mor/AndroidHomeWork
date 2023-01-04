package com.example.androidhomework.domain.auth

import com.example.androidhomework.domain.model.OnBoardingModel
import com.example.androidhomework.domain.model.UserModel
import javax.inject.Inject

class AuthInteractor @Inject constructor(
    private val authRepository: AuthRepository) {

    fun loginUser (userName: String, userPassword: String){
        authRepository.loginUser(userName,userPassword)
    }

    fun getUserCreds(): UserModel{
        return authRepository.showUserCreds()
    }

    fun cheackUserExist(): Boolean {
        return authRepository.doesUserExist()
    }

    fun logoutUser(){
        return authRepository.userLogout()
    }

    fun viewOnBoarding (key: String){
        authRepository.viewOnBoarding(key)
    }

    fun getOnBoardingCreds(): OnBoardingModel{
        return authRepository.showOnBoardingCreds()
    }

    fun checkOnBoardingView(): Boolean{
        return  authRepository.doesUserViewOnBoarding()
    }

}