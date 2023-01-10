package com.example.androidhomework.presentation.view.adapter.view.auth.onBoarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.androidhomework.databinding.FragmentOnBoardingBinding
import com.example.androidhomework.presentation.view.adapter.view.home.items.ItemsFragment
import com.example.androidhomework.utils.NavigationFragment.fmReplace
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class OnBoardingFragment : Fragment() {


    private val viewModel: OnBoardingViewModel by viewModels()

    private var _viewBinding: FragmentOnBoardingBinding? = null
    private val viewBinding: FragmentOnBoardingBinding get() = _viewBinding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viewBinding = FragmentOnBoardingBinding.inflate(inflater)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)




        viewBinding.btnGoToItemsFragment.setOnClickListener {
            viewModel.viewOnBoarding(KEY)
                    fmReplace(parentFragmentManager, ItemsFragment(), false)
                    viewModel.finishPerformed()
        }


    }

    companion object {
        private const val KEY = "KEY"
    }

}