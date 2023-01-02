package com.example.androidhomework.presentation.view.adapter.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.androidhomework.R
import com.example.androidhomework.presentation.view.adapter.view.fragments.LogInFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: ItemsViewMain by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.getMainId()
        viewModel.main.observe(this, Observer { main ->
            val fragmentTransaction = supportFragmentManager.beginTransaction()
            fragmentTransaction.add(main, LogInFragment())
            fragmentTransaction.commit()
        })
    }
}