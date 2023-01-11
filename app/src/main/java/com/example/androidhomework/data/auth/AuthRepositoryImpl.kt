package com.example.androidhomework.data.auth

import com.example.androidhomework.data.sharedPreferences.SharedPreferencesHelper
import com.example.androidhomework.domain.auth.AuthRepository
import com.example.androidhomework.domain.model.OnBoardingModel
import com.example.androidhomework.domain.model.UserModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val sharedPreferencesHelper: SharedPreferencesHelper
) : AuthRepository {

    override suspend fun loginUser(userName: String, userPassword: String) {
        withContext(Dispatchers.IO){
            sharedPreferencesHelper.saveUserName(userName)
            sharedPreferencesHelper.saveUserPassword(userPassword)
        }
    }

    override suspend fun showUserCreds(): UserModel {
        return withContext(Dispatchers.IO){
            sharedPreferencesHelper.getUserCreds()
        }
    }

    override suspend fun doesUserExist(): Boolean {
        return withContext(Dispatchers.IO){
            sharedPreferencesHelper.checkUserExist()
        }
    }

    override suspend fun userLogout() {
        withContext(Dispatchers.IO){
            sharedPreferencesHelper.removeUser()
        }
    }

    override suspend fun viewOnBoarding(key: String) {
        withContext(Dispatchers.IO){
            sharedPreferencesHelper.saveKeyOnBoarding(key)
        }
    }

    override suspend fun showOnBoardingCreds(): OnBoardingModel {
        return withContext(Dispatchers.IO){
            sharedPreferencesHelper.getOnBoardingCreds()
        }
    }

    override suspend fun doesUserViewOnBoarding(): Boolean {
        return withContext(Dispatchers.IO){
            sharedPreferencesHelper.checkOnBoardingView()
        }
    }


}