package com.example.androidhomework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer

class MainActivity : AppCompatActivity() {

    private val viewModel: ItemsViewMain by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.getMainId()
        viewModel.main.observe(this, Observer { main ->
            val fragmentTransaction = supportFragmentManager.beginTransaction()
            fragmentTransaction.add(main, ItemsFragment())
            fragmentTransaction.commit()
        })
    }
}