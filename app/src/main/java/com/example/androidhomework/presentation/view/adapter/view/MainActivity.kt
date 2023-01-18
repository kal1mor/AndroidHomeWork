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
import com.example.androidhomework.presentation.view.adapter.view.home.onBoarding.OnBoardingFragment
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

        viewModel.doesUserExist.observe(this) {
            if (it != true) {
                viewModel.userExist.observe(this) {
                    navController.setGraph(R.navigation.auth_graph)
                }
            } else {
                viewModel.userExist.observe(this) {
                    navController.setGraph(R.navigation.main_graph)
                }
            }
        }
    }
}