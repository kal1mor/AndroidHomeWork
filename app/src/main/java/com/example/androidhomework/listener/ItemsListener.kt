package com.example.androidhomework.listener

interface ItemsListener {

    fun onClick()

    fun onElementSelected(name: String, date: String, imageView: Int)
}