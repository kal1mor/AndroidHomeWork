package com.example.androidhomework.presentation.view.adapter.view.auth.onBoarding

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.example.androidhomework.databinding.FragmentOnBoardingBinding
import com.example.androidhomework.presentation.view.adapter.view.auth.login.LoginPresenter
import com.example.androidhomework.presentation.view.adapter.view.home.items.ItemsFragment
import com.example.androidhomework.utils.NavigationFragment.fmReplace
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject


@AndroidEntryPoint
class OnBoardingFragment : Fragment(), OnBoardingView {

    @Inject
    lateinit var onBoardingPresenter: OnBoardingPresenter

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

        onBoardingPresenter.setView(this)

        viewBinding.btnGoToItemsFragment.setOnClickListener{
                        onBoardingPresenter.viewOnBoarding(KEY)
        }
    }

    override fun userViewOnBoarding() {
        fmReplace(parentFragmentManager, ItemsFragment(), false)
    }

    companion object{
        private const val KEY = "KEY"
    }

}