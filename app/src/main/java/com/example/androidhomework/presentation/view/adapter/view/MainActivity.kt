package com.example.androidhomework.presentation.view.adapter.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.androidhomework.R
import com.example.androidhomework.databinding.ActivityMainBinding
import com.example.androidhomework.presentation.view.adapter.view.auth.login.LogInFragment
import com.example.androidhomework.presentation.view.adapter.view.home.items.ItemsFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), MainView {

    private var _binding: ActivityMainBinding? = null

    @Inject
    lateinit var mainPresenter: MainPresenter

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(R.layout.activity_main)
        setContentView(_binding!!.root)


        mainPresenter.setView(this)

        mainPresenter.checkUserExist()


        val navHostFragment = supportFragmentManager.findFragmentById(
            R.id.activity_container
        ) as NavHostFragment
        navController = navHostFragment.navController
    }

    override fun userExistsResult(userExists: Boolean, userViewOnBoarding: Boolean) {

            if (userExists) {
                navController.setGraph(R.navigation.main_graph)

            } else {
                navController.setGraph(R.navigation.auth_graph)
            }
    }
}
