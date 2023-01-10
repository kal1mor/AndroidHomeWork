package com.example.androidhomework.data.sharedPreferences

import android.content.SharedPreferences
import android.util.Log
import com.example.androidhomework.domain.model.OnBoardingModel
import com.example.androidhomework.domain.model.UserModel
import javax.inject.Inject

class SharedPreferencesHelper @Inject constructor(
    private val sharedPreferences: SharedPreferences
) {
    fun saveUserName(name: String?){
        Log.w("1", "saveUserName $name")
        sharedPreferences.edit().putString(USER_NAME, name).apply()
    }

    fun saveUserPassword(password: String?){
        Log.w("2", "saveUserPassword $password")
        sharedPreferences.edit().putString(USER_PASSWORD, password).apply()
    }

    fun getUserCreds(): UserModel {
        Log.w("3", "getUserCreds")
        val name = sharedPreferences.getString(USER_NAME, "") ?: ""
        val password = sharedPreferences.getString(USER_PASSWORD, "") ?: ""
        return UserModel(name, password)
    }

    fun checkUserExist(): Boolean{
        Log.w("4", "checkUserExist")
        val name = sharedPreferences.getString(USER_NAME, "")
        val password = sharedPreferences.getString(USER_PASSWORD, "")

        return (!name.isNullOrEmpty() && !password.isNullOrEmpty())
    }

    fun saveKeyOnBoarding(key: String?){
        Log.w("5", "saveKeyOnBoarding $key")
        sharedPreferences.edit().putString(KEY, key).apply()
    }

    fun getOnBoardingCreds(): OnBoardingModel {
        Log.w("6", "getOnBoardingCreds")
        val key = sharedPreferences.getString(KEY, "") ?: ""

        return OnBoardingModel(key)
    }

    fun checkOnBoardingView(): Boolean{
        Log.w("7", "checkOnBoardingView")
        val key = sharedPreferences.getString(KEY, "") ?: ""


        return (!key.isNullOrEmpty())
    }

    fun removeUser(){
        Log.w("8", "removeUser")
        saveUserName(null)
        saveUserPassword(null)
    }

    companion object{
        private const val KEY = "KEY"
        private const val USER_NAME = "USER_NAME"
        private const val USER_PASSWORD = "USER_PASSWORD"
    }
}