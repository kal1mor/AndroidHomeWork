package com.example.androidhomework.domain.auth

import com.example.androidhomework.domain.model.OnBoardingModel
import com.example.androidhomework.domain.model.UserModel

interface AuthRepository {

    fun loginUser(userName: String, userPassword: String)

    fun showUserCreds(): UserModel

    fun doesUserExist(): Boolean

    fun userLogout()

    fun viewOnBoarding(key: String)

    fun showOnBoardingCreds(): OnBoardingModel

    fun doesUserViewOnBoarding(): Boolean


}