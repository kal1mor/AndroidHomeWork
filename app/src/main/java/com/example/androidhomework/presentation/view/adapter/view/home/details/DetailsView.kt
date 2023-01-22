package com.example.androidhomework.presentation.view.adapter.view.home.details

interface DetailsView {

    fun userLoggedOut()

    fun displayDetails(name: String, userName: String, email: String)
}