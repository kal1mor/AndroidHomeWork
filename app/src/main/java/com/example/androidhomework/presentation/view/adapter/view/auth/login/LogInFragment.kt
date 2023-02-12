package com.example.androidhomework.presentation.view.adapter.view.auth.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.androidhomework.R
import com.example.androidhomework.databinding.FragmentLogInBinding
import com.example.androidhomework.utils.App
import com.example.androidhomework.utils.NavHelper.replaceGraph
import javax.inject.Inject


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
        (requireActivity().applicationContext as App).provideAppComponent().inject(this)

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
            replaceGraph(R.navigation.main_graph)
        } else {
            Toast.makeText(context, getString(R.string.fields_is_empty), Toast.LENGTH_SHORT)
                .show()
        }
    }


}
