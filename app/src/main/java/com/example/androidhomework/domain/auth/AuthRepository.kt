package com.example.androidhomework.domain.auth

import com.example.androidhomework.domain.model.OnBoardingModel
import com.example.androidhomework.domain.model.UserModel

interface AuthRepository {

    suspend fun loginUser(userName: String, userPassword: String)

    suspend fun showUserCreds(): UserModel

    suspend fun doesUserExist(): Boolean

    suspend fun userLogout()

    suspend fun viewOnBoarding(key: String)

    suspend fun showOnBoardingCreds(): OnBoardingModel

    suspend fun doesUserViewOnBoarding(): Boolean


}