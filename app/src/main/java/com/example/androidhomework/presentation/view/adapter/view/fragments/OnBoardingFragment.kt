package com.example.androidhomework.presentation.view.adapter.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.androidhomework.R
import com.example.androidhomework.databinding.FragmentLogInBinding
import com.example.androidhomework.databinding.FragmentOnBoardingBinding
import com.example.androidhomework.utils.NavigationFragment.fmReplace

class OnBoardingFragment : Fragment() {

    private var _viewBinding: FragmentOnBoardingBinding? = null
    private val viewBinding get() = _viewBinding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _viewBinding = FragmentOnBoardingBinding.inflate(inflater)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewBinding.btnGoToItemsFragment.setOnClickListener{
            fmReplace(parentFragmentManager, ItemsFragment(), false)
        }
    }
}