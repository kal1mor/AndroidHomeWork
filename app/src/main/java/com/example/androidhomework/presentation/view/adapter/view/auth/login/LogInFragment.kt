package com.example.androidhomework.presentation.view.adapter.view.auth.login

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.example.androidhomework.R
import com.example.androidhomework.databinding.FragmentLogInBinding
import com.example.androidhomework.presentation.view.adapter.view.auth.onBoarding.OnBoardingFragment
import com.example.androidhomework.presentation.view.adapter.view.home.items.ItemsFragment
import com.example.androidhomework.utils.NavigationFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject


@AndroidEntryPoint
class LogInFragment : Fragment(), LoginView {

    @Inject
    lateinit var loginPresenter: LoginPresenter

    private var _viewBinding: FragmentLogInBinding? = null
    private val viewBinding get() = _viewBinding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _viewBinding = FragmentLogInBinding.inflate(inflater)
        return viewBinding.root
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {

        super.onViewCreated(view, savedInstanceState)

        loginPresenter.setView(this)

        viewBinding.btnLogin.setOnClickListener {
            loginPresenter.loginUser(
                viewBinding.tetEmail.text.toString(),
                viewBinding.tetPassword.text.toString()
            )
        }
    }

    override fun userLoggedIn(userViewOnBoarding: Boolean) {
        if (viewBinding.tetEmail.text.toString()
                .isNotEmpty() && viewBinding.tetPassword.text.toString().isNotEmpty()
        ) {
            if (!userViewOnBoarding) {
                NavigationFragment.fmReplace(parentFragmentManager, OnBoardingFragment(), false)
            } else {
                NavigationFragment.fmReplace(parentFragmentManager, ItemsFragment(), false)
            }
        } else {
            Toast.makeText(context, getString(R.string.fields_is_empty), Toast.LENGTH_SHORT).show()
        }
    }

}