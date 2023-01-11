package com.example.androidhomework.domain.auth

import com.example.androidhomework.domain.model.OnBoardingModel
import com.example.androidhomework.domain.model.UserModel
import javax.inject.Inject

class AuthInteractor @Inject constructor(
    private val authRepository: AuthRepository) {

    suspend fun loginUser (userName: String, userPassword: String){
        authRepository.loginUser(userName,userPassword)
    }

    suspend fun getUserCreds(): UserModel{
        return authRepository.showUserCreds()
    }

    suspend fun cheackUserExist(): Boolean {
        return authRepository.doesUserExist()
    }

    suspend fun logoutUser(){
        return authRepository.userLogout()
    }

    suspend fun viewOnBoarding (key: String){
        authRepository.viewOnBoarding(key)
    }

    suspend fun getOnBoardingCreds(): OnBoardingModel{
        return authRepository.showOnBoardingCreds()
    }

    suspend fun checkOnBoardingView(): Boolean{
        return  authRepository.doesUserViewOnBoarding()
    }

}