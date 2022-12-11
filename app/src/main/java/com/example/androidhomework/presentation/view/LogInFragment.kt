package com.example.androidhomework.presentation.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.androidhomework.R
import com.example.androidhomework.databinding.FragmentItemsBinding
import com.example.androidhomework.databinding.FragmentLogInBinding

class LogInFragment : Fragment() {

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
        savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)

        viewBinding.btnLogin.setOnClickListener{
            if (viewBinding.tetEmail.text.toString().isNotEmpty() && viewBinding.tetPassword.text.toString().isNotEmpty()) {
                parentFragmentManager
                    .beginTransaction()
                    .replace(R.id.activity_container, ItemsFragment())
                    .commit()
            } else {
                Toast.makeText(context, getString(R.string.fields_is_empty), Toast.LENGTH_SHORT).show()
            }
        }
    }

}