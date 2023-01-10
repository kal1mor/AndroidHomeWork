package com.example.androidhomework.presentation.view.adapter.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.viewModels
import com.example.androidhomework.R
import com.example.androidhomework.databinding.ActivityMainBinding
import com.example.androidhomework.presentation.view.adapter.view.auth.login.LogInFragment
import com.example.androidhomework.presentation.view.adapter.view.auth.onBoarding.OnBoardingFragment
import com.example.androidhomework.presentation.view.adapter.view.home.items.ItemsFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null

    private val viewModel: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(R.layout.activity_main)
        setContentView(_binding!!.root)


        viewModel.checkUserExist()
        viewModel.checkUserViewOnBoarding()

        viewModel.userExist.observe(this) {
            val fragmentTransaction = supportFragmentManager.beginTransaction()
            fragmentTransaction.add(
                R.id.activity_container,
                when (it) {
                    true -> {
                        if (viewModel.userViewOnBoarding.value == true) {
                            ItemsFragment()
                        } else {
                            OnBoardingFragment()
                        }
                    }
                    false -> LogInFragment()
                }
            )
            fragmentTransaction.commit()
        }
    }
}