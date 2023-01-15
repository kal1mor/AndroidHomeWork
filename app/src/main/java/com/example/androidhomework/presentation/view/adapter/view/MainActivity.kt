package com.example.androidhomework.presentation.view.adapter.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
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

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(R.layout.activity_main)
        setContentView(_binding!!.root)


        viewModel.checkUserExist()


        val navHostFragment = supportFragmentManager.findFragmentById(
            R.id.activity_container
        ) as NavHostFragment

        navController = navHostFragment.navController
        Log.w("5", "5")
        viewModel.userViewOnBoarding.observe(this) {
            Log.w("4", "4")
            when (it) {
                true -> {
                    Log.w("4", "4")
                    viewModel.key.observe(this) {
                        when (it) {
                            1 -> viewModel.userExist.observe(this) {
                                navController.setGraph(it!!)
                            }

                            2 -> viewModel.userExist.observe(this) {
                                navController.navigate(it!!)
                            }
                            3 -> viewModel.userExist.observe(this) {
                                navController.setGraph(it!!)
                            }
                        }
                    }
                }
                false -> {
                    Log.w("3", "3")
                    viewModel.userExist.observe(this) {
                        navController.setGraph(it!!)
                    }
                }
            }
        }
    }
}