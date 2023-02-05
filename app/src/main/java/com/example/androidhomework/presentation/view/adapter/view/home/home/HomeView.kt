package com.example.androidhomework.presentation.view.adapter.view.home.home

import com.example.androidhomework.domain.model.HomeModel

interface HomeView {

    fun dataReceived(list: List<HomeModel>)

}