package com.example.androidhomework.presentation.view.adapter.view.auth.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.androidhomework.R
import com.example.androidhomework.databinding.FragmentLogInBinding
import com.example.androidhomework.utils.NavHelper.navigate
import com.example.androidhomework.utils.NavHelper.navigateWithDeletedBackStack
import com.example.androidhomework.utils.NavHelper.replaceGraph
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class LogInFragment : Fragment() {

    private val viewModel: LoginViewModel by viewModels()

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



        viewBinding.btnLogin.setOnClickListener {
            viewModel.loginUser(
                viewBinding.tetEmail.text.toString(),
                viewBinding.tetPassword.text.toString()
            )
        }

        viewModel.nav.observe(viewLifecycleOwner) {
            if (it != null) {
                viewModel.key.observe(viewLifecycleOwner) {
                    if (it == 1) {
                        viewModel.userViewOnBoarding.observe(viewLifecycleOwner) {
                            replaceGraph(it!!)
                        }
                    }else if (it == 2){
                            viewModel.userViewOnBoarding.observe(viewLifecycleOwner) {
                                navigate(it!!)
                            }
                        }
                    }
                } else {
                Toast.makeText(context, getString(R.string.fields_is_empty), Toast.LENGTH_SHORT).show()
            }
        }
    }
}