package com.example.androidhomework.data.auth

import com.example.androidhomework.data.sharedPreferences.SharedPreferencesHelper
import com.example.androidhomework.domain.auth.AuthRepository
import com.example.androidhomework.domain.model.OnBoardingModel
import com.example.androidhomework.domain.model.UserModel
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val sharedPreferencesHelper: SharedPreferencesHelper
) : AuthRepository {

    override fun loginUser(userName: String, userPassword: String) {
        sharedPreferencesHelper.saveUserName(userName)
        sharedPreferencesHelper.saveUserPassword(userPassword)
    }

    override fun showUserCreds(): UserModel {
        return sharedPreferencesHelper.getUserCreds()
    }

    override fun doesUserExist(): Boolean {
        return sharedPreferencesHelper.checkUserExist()
    }

    override fun userLogout() {
        sharedPreferencesHelper.removeUser()
    }

    override fun viewOnBoarding(key: String) {
        sharedPreferencesHelper.saveKeyOnBoarding(key)
    }

    override fun showOnBoardingCreds(): OnBoardingModel {
        return sharedPreferencesHelper.getOnBoardingCreds()
    }

    override fun doesUserViewOnBoarding(): Boolean {
        return sharedPreferencesHelper.checkOnBoardingView()
    }


}