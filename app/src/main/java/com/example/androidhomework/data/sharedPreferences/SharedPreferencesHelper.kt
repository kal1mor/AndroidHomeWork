package com.example.androidhomework.data.sharedPreferences

import android.content.SharedPreferences
import com.example.androidhomework.domain.model.OnBoardingModel
import com.example.androidhomework.domain.model.UserModel
import javax.inject.Inject

class SharedPreferencesHelper @Inject constructor(
    private val sharedPreferences: SharedPreferences
) {
    fun saveUserName(name: String?){
        sharedPreferences.edit().putString(USER_NAME, name).apply()
    }

    fun saveUserPassword(password: String?){
        sharedPreferences.edit().putString(USER_PASSWORD, password).apply()
    }

    fun getUserCreds(): UserModel {
        val name = sharedPreferences.getString(USER_NAME, "") ?: ""
        val password = sharedPreferences.getString(USER_PASSWORD, "") ?: ""
        return UserModel(name, password)
    }

    fun checkUserExist(): Boolean{
        val name = sharedPreferences.getString(USER_NAME, "")
        val password = sharedPreferences.getString(USER_PASSWORD, "")

        return (!name.isNullOrEmpty() && !password.isNullOrEmpty())
    }

    fun saveKeyOnBoarding(key: String?){
        sharedPreferences.edit().putString(KEY, key).apply()
    }

    fun getOnBoardingCreds(): OnBoardingModel {
        val key = sharedPreferences.getString(KEY, "") ?: ""

        return OnBoardingModel(key)
    }

    fun checkOnBoardingView(): Boolean{
        val key = sharedPreferences.getString(KEY, "") ?: ""


        return (!key.isNullOrEmpty())
    }

    fun removeUser(){
        saveUserName(null)
        saveUserPassword(null)
    }

    companion object{
        private const val KEY = "KEY"
        private const val USER_NAME = "USER_NAME"
        private const val USER_PASSWORD = "USER_PASSWORD"
    }
}