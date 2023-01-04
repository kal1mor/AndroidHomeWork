package com.example.androidhomework.presentation.view.adapter.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.androidhomework.R
import com.example.androidhomework.databinding.ActivityMainBinding
import com.example.androidhomework.presentation.view.adapter.view.auth.login.LogInFragment
import com.example.androidhomework.presentation.view.adapter.view.auth.onBoarding.OnBoardingFragment
import com.example.androidhomework.presentation.view.adapter.view.home.items.ItemsFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), MainView {

    private var _binding: ActivityMainBinding? = null

    @Inject
    lateinit var mainPresenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(R.layout.activity_main)
        setContentView(_binding!!.root)


        mainPresenter.setView(this)

        mainPresenter.checkUserExist()

        mainPresenter.checkUserViewOnBoarding()

    }

    override fun userExistsResult(userExists: Boolean, userViewOnBoarding: Boolean) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.activity_container,
            if (userExists && userViewOnBoarding){
                ItemsFragment()
            } else if (userExists && !userViewOnBoarding){
                OnBoardingFragment()
            } else {
                LogInFragment()
            }
        )
        fragmentTransaction.commit()
    }

    override fun userViewOnBoardingResult(userViewOnBoarding: Boolean) {
//        val fragmentTransaction = supportFragmentManager.beginTransaction()
//        fragmentTransaction.add(R.id.activity_container,
//            when(userViewOnBoarding){
//                true -> ItemsFragment()
//                false -> OnBoardingFragment()
//            }
//        )
//        fragmentTransaction.commit()
    }
}